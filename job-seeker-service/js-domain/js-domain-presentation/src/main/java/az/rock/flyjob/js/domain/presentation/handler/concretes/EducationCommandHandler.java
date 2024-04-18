package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.education.EducationDomainException;
import az.rock.flyjob.js.domain.core.exception.education.EducationNotFoundException;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractEducationCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractEducationDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractEducationCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.command.create.EducationCreatedEvent;
import com.intellibucket.lib.payload.event.command.delete.EducationDeletedEvent;
import com.intellibucket.lib.payload.event.command.update.EducationUpdatedEvent;
import com.intellibucket.lib.payload.payload.command.EducationPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;


@Component
@Slf4j
public class EducationCommandHandler implements AbstractEducationCommandHandler<AbstractDomainEvent<?>> {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationCommandRepositoryAdapter educationCommandRepositoryAdapter;
    private final AbstractEducationDomainMapper educationDomainMapper;
    private final AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter;

    public EducationCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                   AbstractEducationCommandRepositoryAdapter educationCommandRepositoryAdapter,
                                   AbstractEducationDomainMapper educationDomainMapper,
                                   AbstractEducationQueryRepositoryAdapter abstractEducationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.educationCommandRepositoryAdapter = educationCommandRepositoryAdapter;
        this.educationDomainMapper = educationDomainMapper;
        this.educationQueryRepositoryAdapter = abstractEducationQueryRepositoryAdapter;
    }


    @Override
    public AbstractDomainEvent<EducationPayload> create(CreateRequest<EducationCommandModel> request) {
        var resumeID = this.securityContextHolder.availableResumeID();
        var educationRoot = this.educationDomainMapper.toNewRoot(resumeID, request.getModel());
        var optionalEducationRoot = this.educationCommandRepositoryAdapter.create(educationRoot)
                .orElseThrow(NoActiveRowException::new);
        var educationPayload = this.educationDomainMapper.toPayload(optionalEducationRoot);
        return EducationCreatedEvent.of(educationPayload);
    }

    @Override
    public AbstractDomainEvent<EducationPayload> update(UpdateRequest<EducationCommandModel> request) throws EducationDomainException {
        var resumeId = securityContextHolder.availableResumeID();
        var educationRootFromDatabase = this.educationQueryRepositoryAdapter
                .findByResumeAndUuidAndRowStatusTrue(resumeId, request.getTargetId()).orElseThrow(EducationNotFoundException::new);
        educationDomainMapper.toExistRoot(educationRootFromDatabase, request.getModel());
        this.educationCommandRepositoryAdapter.update(educationRootFromDatabase);
        var educationPayload = this.educationDomainMapper.toPayload(educationRootFromDatabase);
        return EducationUpdatedEvent.of(educationPayload);
    }

    @Override
    public AbstractDomainEvent<UUID> delete(UUID educationId) throws EducationDomainException {
        var resumeID = securityContextHolder.availableResumeID();
        var educationFromDatabase = educationQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeID, educationId)
                .orElseThrow(EducationNotFoundException::new);
        educationCommandRepositoryAdapter.inActive(educationFromDatabase);
        return EducationDeletedEvent.of(educationId);
    }


    @Override
    public AbstractDomainEvent<EducationPayload> reorder(ReorderCommandModel request) throws EducationDomainException {
        var resumeId = securityContextHolder.availableResumeID();
        List<EducationRoot> educations = educationQueryRepositoryAdapter.findAllByPID(resumeId);
        var education = educations.stream().filter(
                e -> e.getRootID().getAbsoluteID().equals(request.getTargetId())
        ).findFirst().orElseThrow(EducationNotFoundException::new);
        var reOrderNumber = request.getOrderNumber();
        if (request.getOrderNumber() > education.getOrderNumber()) ++reOrderNumber;
        education.changeOrderNumber(reOrderNumber);
        educations.stream()
                .filter(e -> e.getOrderNumber() >= education.getOrderNumber() && !e.equals(e))
                .forEach(e -> e.changeOrderNumber(e.getOrderNumber() + 1));
        int orderCounter = 1;
        for (EducationRoot educationRoot : educations.stream()
                .sorted(Comparator.comparingInt(EducationRoot::getOrderNumber))
                .toList()) {
            educationRoot.changeOrderNumber(orderCounter++);
        }
        educationCommandRepositoryAdapter.updateAll(educations);
        return EducationUpdatedEvent.of(
                EducationPayload
                        .builder()
                        .id(request.getTargetId())
                        .build());
    }


}
