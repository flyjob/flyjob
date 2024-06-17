package az.rock.flyjob.js.presentation.api.rest.privates.query;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleAnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleMyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractContactQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.ContactQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/contact",produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactQueryPrivateController implements ContactQueryPrivateSpec {
    private final AbstractContactQueryDomainPresentationService abstractContactQueryDomainPresentationService;

    public ContactQueryPrivateController(AbstractContactQueryDomainPresentationService abstractContactQueryDomainPresentationService) {
        this.abstractContactQueryDomainPresentationService = abstractContactQueryDomainPresentationService;
    }

    @Override
    @GetMapping(value = "/get-all/contacts")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyContactResponseModel>>> queryAllMyContacts(SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllMyContacts(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-all/any/contacts")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyContactResponseModel>>> queryAllAnyContacts(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllAnyContacts(pageableRequest);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }


    @Override
    @GetMapping(value = "/get-all-my-simple/contacts")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyContactResponseModel>>> queryAllMySimpleContacts(SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllMySimpleContacts(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-all-any-simple/contacts")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyContactResponseModel>>> queryAllAnySimpleContacts(UUID targetResumeID ,SimplePageableRequest pageableRequest) {
        var response=this.abstractContactQueryDomainPresentationService.queryAllAnySimpleContacts(targetResumeID,pageableRequest);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value ="/get-my/{contactUUId}")
    public ResponseEntity<JSuccessDataResponse<MyContactResponseModel>> findMyContactById(@PathVariable(value = "contactUUId") UUID id) {

        var response =this.abstractContactQueryDomainPresentationService.findMyContactById(id);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping(value = "/get-any/{contactUUId}")
    public ResponseEntity<JSuccessDataResponse<AnyContactResponseModel>> findAnyContactById(@PathVariable(value = "contactUUId") UUID id) {
        var response=this.abstractContactQueryDomainPresentationService.findAnyContactById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
}
