package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;

import java.util.UUID;

public interface AbstractEducationCommandDomainPresentationService {
    void create(CreateRequest<EducationCommandModel> request);

    void update(UpdateRequest<EducationCommandModel> request);

    void delete(UUID educationId);

    void reorder(ReorderCommandModel request);
}
