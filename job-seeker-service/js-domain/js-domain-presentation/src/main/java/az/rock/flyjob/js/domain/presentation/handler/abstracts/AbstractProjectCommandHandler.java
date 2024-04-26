package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)

public interface AbstractProjectCommandHandler<E extends AbstractDomainEvent<?>> {

    E  create(CreateRequest<ProjectCommandModel> request);
    E update(UpdateRequest<ProjectCommandModel> request);

    E delete(UUID id);
    E reorder(ReorderCommandModel commandModel);

}
