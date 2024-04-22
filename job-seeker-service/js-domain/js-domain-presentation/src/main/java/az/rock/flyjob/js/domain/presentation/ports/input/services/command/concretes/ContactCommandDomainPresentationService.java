package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractContactCommandDomainPresentationService;
import az.rock.lib.jexception.JRuntimeException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContactCommandDomainPresentationService implements AbstractContactCommandDomainPresentationService {


    private final AbstractContactCommandHandler abstractContactCommandHandler;

    public ContactCommandDomainPresentationService(AbstractContactCommandHandler abstractContactCommandHandler) {
        this.abstractContactCommandHandler = abstractContactCommandHandler;
    }

    @Override
    public void create(CreateRequest<ContactCommandModel> request) {
        try{
            this.abstractContactCommandHandler.createContact(request);
        }
        catch (Exception e){
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void update(UpdateRequest<ContactCommandModel> request) {
        try{
            this.abstractContactCommandHandler.updateContact(request);
        }
        catch (Exception e){
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void delete(UUID contactId) {
        try{
            this.abstractContactCommandHandler.deleteContact(contactId);
        }
        catch (Exception e){
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void deleteAll() {
        try{
            this.abstractContactCommandHandler.deleteAllContact();
        }
        catch (Exception e){
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void reorder(ReorderCommandModel request) {
        try{
            this.abstractContactCommandHandler.reOrderContact(request);
        }
        catch (Exception e){
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

}
