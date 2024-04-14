package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import com.intellibucket.lib.payload.event.command.create.ExperienceMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.ExperienceDeleteEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractExperienceCommandHandler {
    ExperienceMergeEvent create(ExperienceCommandModel commandModel);
    ExperienceMergeEvent update(ExperienceCommandModel commandModel);
    ExperienceDeleteEvent delete(UUID uuid);
    ExperienceMergeEvent reorder(ExperienceCommandModel commandModel);

}
