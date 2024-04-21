package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.core.exception.experience.ExperienceDomainException;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import com.intellibucket.lib.payload.event.command.create.ExperienceMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.ExperienceDeleteEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractExperienceCommandHandler {
    ExperienceMergeEvent create(CreateRequest<ExperienceCommandModel> commandModel) throws ExperienceDomainException;
    ExperienceMergeEvent update(UpdateRequest<ExperienceCommandModel> commandModel) throws ExperienceDomainException;
    ExperienceDeleteEvent delete(UUID uuid);
    ExperienceDeleteEvent deleteAll();
    ExperienceMergeEvent reorder(ReorderCommandModel commandModel) throws ExperienceDomainException;

}
