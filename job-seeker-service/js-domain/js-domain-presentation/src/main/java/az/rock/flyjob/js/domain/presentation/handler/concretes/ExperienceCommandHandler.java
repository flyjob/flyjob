package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractExperienceCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractExperienceQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import com.intellibucket.lib.payload.event.command.create.ExperienceMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.ExperienceDeleteEvent;

import java.util.UUID;

public class ExperienceCommandHandler implements AbstractExperienceCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractExperienceQueryRepositoryAdapter experienceQueryRepositoryAdapter;

    public ExperienceCommandHandler(AbstractSecurityContextHolder securityContextHolder, AbstractExperienceQueryRepositoryAdapter experienceQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.experienceQueryRepositoryAdapter = experienceQueryRepositoryAdapter;
    }

    @Override
    public ExperienceMergeEvent create(ExperienceCommandModel commandModel) {
        return null;
    }

    @Override
    public ExperienceMergeEvent update(ExperienceCommandModel commandModel) {
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
