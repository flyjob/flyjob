package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional
public interface AbstractInterestCommandDomainPresentationService  {
    void create(InterestCommandModel newInterestCommandModel) ;


    void update(UpdateRequest<InterestCommandModel> updateRequest) ;

    void delete(UUID interestId);

    void  reorder(ReorderCommandModel request) ;
}
