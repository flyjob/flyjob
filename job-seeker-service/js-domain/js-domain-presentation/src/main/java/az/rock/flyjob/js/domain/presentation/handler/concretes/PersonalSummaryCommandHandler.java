package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.summary.SummaryAlreadyExist;
import az.rock.flyjob.js.domain.core.exception.summary.SummaryNotFound;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.PersonalSummaryCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractPersonalSummaryCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractPersonalSummaryDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractPersonalSummaryCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractPersonalSummaryQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.PersonalSummaryID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimpleContext;
import com.intellibucket.lib.payload.event.command.create.PersonalSummaryCreatedEvent;
import com.intellibucket.lib.payload.event.command.delete.PersonalSummaryDeletedEvent;
import com.intellibucket.lib.payload.event.command.update.PersonalSummaryChangedEvent;
import com.intellibucket.lib.payload.payload.command.SummaryChangePayload;
import com.intellibucket.lib.payload.payload.command.SummaryCreatePayload;
import com.intellibucket.lib.payload.payload.command.SummaryDeletePayload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PersonalSummaryCommandHandler implements AbstractPersonalSummaryCommandHandler {
    private final AbstractSecurityContextHolder contextHolder;
    private final AbstractPersonalSummaryQueryRepositoryAdapter summaryQueryRepositoryAdapter;
    private final AbstractPersonalSummaryCommandRepositoryAdapter summaryCommandRepositoryAdapter;
    private final AbstractPersonalSummaryDomainMapper personalSummaryDomainMapper;
    private final List<AccessModifier> modifierList = List.of(AccessModifier.values());


    public PersonalSummaryCommandHandler(AbstractSecurityContextHolder contextHolder,
                                         @Qualifier(value = "personalSummaryQueryRepositoryAdapter") AbstractPersonalSummaryQueryRepositoryAdapter summaryQueryRepositoryAdapter,
                                         @Qualifier(value = "personalSummaryCommandRepositoryAdapter") AbstractPersonalSummaryCommandRepositoryAdapter summaryCommandRepositoryAdapter,
                                         AbstractPersonalSummaryDomainMapper personalSummaryDomainMapper) {
        this.contextHolder = contextHolder;
        this.summaryQueryRepositoryAdapter = summaryQueryRepositoryAdapter;
        this.summaryCommandRepositoryAdapter = summaryCommandRepositoryAdapter;
        this.personalSummaryDomainMapper = personalSummaryDomainMapper;
    }

    @Override
    @Transactional
    public PersonalSummaryCreatedEvent createSummary(PersonalSummaryCommandModel context) throws SummaryAlreadyExist {
        var resumeID = this.contextHolder.availableResumeID();
        var summary = this.summaryQueryRepositoryAdapter.findByPID(resumeID);
        if (summary.isEmpty()) {
            var newRoot = this.personalSummaryDomainMapper.toNewRoot(resumeID, context);
            this.summaryCommandRepositoryAdapter.createSummary(newRoot);
            var payload = this.toPayload(newRoot);
            return PersonalSummaryCreatedEvent.of(payload);
        } else throw new SummaryAlreadyExist();

    }

    @Override
    @Transactional
    public PersonalSummaryChangedEvent changeSummary(SimpleContext context) throws SummaryNotFound {
        var resumeID = this.contextHolder.availableResumeID();
        var oldSummaryRoot = this.summaryQueryRepositoryAdapter.findByPID(resumeID, PersonalSummaryID.of(context.getTargetId()), modifierList);
        if (oldSummaryRoot.isPresent()) {

            var personalSummaryRoot = oldSummaryRoot.get();
            var updatedSummaryRoot = this.personalSummaryDomainMapper.toRoot(personalSummaryRoot, context);
            this.summaryCommandRepositoryAdapter.changeSummary(updatedSummaryRoot);

            var summaryChangePayload = SummaryChangePayload.of(context.getTargetId());
            return PersonalSummaryChangedEvent.of(summaryChangePayload);
        } else throw new SummaryNotFound();


    }

    @Override
    @Transactional
    public PersonalSummaryDeletedEvent deleteSummary(UUID summaryId) throws SummaryNotFound {
        var resumeID = this.contextHolder.availableResumeID();
        var summary = this.summaryQueryRepositoryAdapter.findByPID(resumeID, PersonalSummaryID.of(summaryId), modifierList);
        if (summary.isPresent()) {
            var personalSummaryRoot = summary.get();
            this.summaryCommandRepositoryAdapter.deleteSummary(personalSummaryRoot);
            var summaryDeletePayload = SummaryDeletePayload.of(summaryId);
            return PersonalSummaryDeletedEvent.of(summaryDeletePayload);

        } else throw new SummaryNotFound();
    }

    private SummaryCreatePayload toPayload(PersonalSummaryRoot root) {
        return SummaryCreatePayload.Builder.builder()
                .resumeId(root.getResume().getRootID())
                .summaryId(root.getRootID().getAbsoluteID())
                .context(root.getSummary())
                .build();
    }
}
