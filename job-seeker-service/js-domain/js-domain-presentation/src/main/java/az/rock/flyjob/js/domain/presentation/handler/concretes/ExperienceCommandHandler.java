package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractExperienceCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractExperienceDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractExperienceCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractExperienceQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.payload.event.command.create.ExperienceMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.ExperienceDeleteEvent;
import com.intellibucket.lib.payload.payload.command.ExperiencePayload;

import java.util.UUID;

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
        var resumeId=this.securityContextHolder.availableResumeID();
        var experienceRoot=this.experienceDomainMapper.toNewRoot(resumeId,request.getModel());
        var optionalExperienceRoot=this.experienceCommandRepositoryAdapter.create(experienceRoot)
                .orElseThrow(NoActiveRowException::new);
        return ExperienceMergeEvent.of(ExperiencePayload.of(optionalExperienceRoot.getRootID().getRootID()));
    }

    @Override
    public ExperienceMergeEvent update(UpdateRequest<ExperienceCommandModel> request) {
        var resumeId=this.securityContextHolder.availableResumeID();
        var experienceDb=this.experienceQueryRepositoryAdapter
                .findByResumeAndUuidAndRowStatusTrue(ResumeID.of(resumeId.getRootID()),request.getTargetId());
                return null;
    }

    @Override
    public ExperienceDeleteEvent delete(UUID uuid) {
        return null;
    }

    @Override
    public ExperienceMergeEvent reorder(ExperienceCommandModel commandModel) {
        return null;
    }
}
