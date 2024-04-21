package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.experience.ExperienceNotFoundException;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractExperienceCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractExperienceDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractExperienceCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractExperienceQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.payload.event.command.create.ExperienceMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.ExperienceDeleteEvent;
import com.intellibucket.lib.payload.payload.command.ExperiencePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class ExperienceCommandHandler implements AbstractExperienceCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractExperienceQueryRepositoryAdapter experienceQueryRepositoryAdapter;
    private final AbstractExperienceCommandRepositoryAdapter experienceCommandRepositoryAdapter;
    private final AbstractExperienceDomainMapper experienceDomainMapper;

    public ExperienceCommandHandler(AbstractSecurityContextHolder securityContextHolder
            , AbstractExperienceQueryRepositoryAdapter experienceQueryRepositoryAdapter
            , AbstractExperienceCommandRepositoryAdapter experienceCommandRepositoryAdapter
            , AbstractExperienceDomainMapper experienceDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.experienceQueryRepositoryAdapter = experienceQueryRepositoryAdapter;
        this.experienceCommandRepositoryAdapter = experienceCommandRepositoryAdapter;
        this.experienceDomainMapper = experienceDomainMapper;
    }

    @Override
    public ExperienceMergeEvent create(CreateRequest<ExperienceCommandModel> request) {
        var resumeId = this.securityContextHolder.availableResumeID();
        var experienceRoot = this.experienceDomainMapper.toNewRoot(resumeId, request.getModel());
        var optionalExperienceRoot = this.experienceCommandRepositoryAdapter.create(experienceRoot)
                .orElseThrow(NoActiveRowException::new);
        var payload = this.experienceDomainMapper.toPayload(optionalExperienceRoot);
        return ExperienceMergeEvent.of(payload);
    }

    @Override
    public ExperienceMergeEvent update(UpdateRequest<ExperienceCommandModel> request) throws ExperienceNotFoundException {
        var resumeId = this.securityContextHolder.availableResumeID();
        var experienceDb = this.experienceQueryRepositoryAdapter
                .findByResumeAndUuidAndRowStatusTrue(ResumeID.of(resumeId.getRootID()), request.getTargetId())
                .orElseThrow(ExperienceNotFoundException::new);
        this.experienceDomainMapper.toExistRoot(experienceDb, request.getModel());
        this.experienceCommandRepositoryAdapter.update(experienceDb);
        var payload = this.experienceDomainMapper.toPayload(experienceDb);
        return ExperienceMergeEvent.of(payload);
    }

    @Override
    public ExperienceDeleteEvent delete(UUID uuid) {
        var resumeId = this.securityContextHolder.availableResumeID();
        var experienceRoot = this.experienceQueryRepositoryAdapter.findOwnByID(resumeId, ExperienceID.of(uuid));
        this.experienceCommandRepositoryAdapter.delete(experienceRoot.get());
        return ExperienceDeleteEvent.of(uuid);
    }

    @Override
    public ExperienceDeleteEvent deleteAll() {
        var resumeId = this.securityContextHolder.availableResumeID();
        var experiences = this.experienceQueryRepositoryAdapter.findAllByPID(resumeId);
        this.experienceCommandRepositoryAdapter.deleteAll(experiences);
         return  ExperienceDeleteEvent
    }

    @Override
    public ExperienceMergeEvent reorder(ReorderCommandModel request) throws ExperienceNotFoundException {
        var resumeId = securityContextHolder.availableResumeID();
        List<ExperienceRoot> experiences = experienceQueryRepositoryAdapter.findAllByPID(resumeId);
        var experience = experiences.stream().filter(
                e -> e.getRootID().getAbsoluteID().equals(request.getTargetId())
        ).findFirst().orElseThrow(ExperienceNotFoundException::new);
        var reOrderNumber = request.getOrderNumber();
        if (request.getOrderNumber() > experience.getOrderNumber()) ++reOrderNumber;
        experience.changeOrderNumber(reOrderNumber);
        experiences.stream()
                .filter(e -> e.getOrderNumber() >= experience.getOrderNumber() && !e.equals(e))
                .forEach(e -> e.changeOrderNumber(e.getOrderNumber() + 1));
        int orderCounter = 1;
        for (ExperienceRoot experienceRoot : experiences.stream()
                .sorted(Comparator.comparingInt(ExperienceRoot::getOrderNumber))
                .toList()) {
            experienceRoot.changeOrderNumber(orderCounter++);
        }
        experienceCommandRepositoryAdapter.updateAll(experiences);

        return ExperienceMergeEvent.of(ExperiencePayload.Builder
                .builder()
                .id(request.getTargetId())
                .build());
    }
}
