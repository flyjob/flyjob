package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.core.exception.education.EducationDomainException;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractEducationCommandHandler<E extends AbstractDomainEvent<?>> {

    E create(CreateRequest<EducationCommandModel> request) throws EducationDomainException;

    E update(UpdateRequest<EducationCommandModel> request) throws EducationDomainException;

    E delete(UUID educationId) throws EducationDomainException;

    E reorder(ReorderCommandModel request) throws EducationDomainException;
}
