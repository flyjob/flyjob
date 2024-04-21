package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@InputPort
@Transactional
public interface AbstractExperienceCommandDomainPresentationService {
    void create(CreateRequest<ExperienceCommandModel> request);
    void update(UpdateRequest<ExperienceCommandModel> request);
    void delete(UUID uuid);
    void deleteAll();
    void reorder(ReorderCommandModel request);
}
