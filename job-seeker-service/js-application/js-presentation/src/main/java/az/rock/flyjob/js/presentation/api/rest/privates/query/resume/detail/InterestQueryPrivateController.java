package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.InterestQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/interest", produces = MediaType.APPLICATION_JSON_VALUE)
public class InterestQueryPrivateController implements InterestQueryPrivateSpec {

    private final AbstractInterestQueryDomainPresentationService abstractInterestQueryDomainPresentationService;

    public InterestQueryPrivateController(@Qualifier("interestQueryDomainPresentationService") AbstractInterestQueryDomainPresentationService abstractInterestQueryDomainPresentationService) {
        this.abstractInterestQueryDomainPresentationService = abstractInterestQueryDomainPresentationService;
    }

    @Override
    @GetMapping(value = "/get-my/all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyInterestResponseModel>>> queryAllMyInterests(@ModelAttribute SimplePageableRequest pageableRequest) {
       var allMyInterests = this.abstractInterestQueryDomainPresentationService.queryAllMyInterests(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allMyInterests));
    }

    @Override
    @GetMapping("/get-any/all/{resumeId}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyInterestResponseModel>>> queryAllAnyInterests(@PathVariable("resumeId") UUID targetResumeId, @ModelAttribute SimplePageableRequest pageableRequest) {
        var anyInterestResponseModels = this.abstractInterestQueryDomainPresentationService.queryAllAnyInterests(targetResumeId, pageableRequest);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(anyInterestResponseModels));
    }


    @Override
    @GetMapping(value = "/get-my-simple/all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyInterestResponseModel>>> queryAllMySimpleInterests(@ModelAttribute SimplePageableRequest pageableRequest) {
      var allMySimpleInterests = this.abstractInterestQueryDomainPresentationService.queryAllMySimpleInterests(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allMySimpleInterests));
    }

    @Override
    @GetMapping(value = "/get-any/simple/{resumeID}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyInterestResponseModel>>> queryAllAnySimpleInterests(@PathVariable("resumeID") UUID targetResumeId, @ModelAttribute SimplePageableRequest pageableRequest) {
      var simpleInterestsResponse = this.abstractInterestQueryDomainPresentationService.queryAllAnySimpleInterests(targetResumeId, pageableRequest);
           return  ResponseEntity.ok(new JSuccessDataResponse<>(simpleInterestsResponse));
    }


    @Override
    @GetMapping(value = "/get-my/{interestUUID}")
    public ResponseEntity<JSuccessDataResponse<MyInterestResponseModel>> findMyInterestById(@PathVariable("interestUUID")UUID id) {
        var myInterestById = this.abstractInterestQueryDomainPresentationService.findMyInterestById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(myInterestById));
    }

    @Override
    @GetMapping("/get-any/{interestId}")
    public ResponseEntity<JSuccessDataResponse<AnyInterestResponseModel>> findAnyInterestById(@PathVariable("interestId") UUID id) {
        var anyInterestById = this.abstractInterestQueryDomainPresentationService.findAnyInterestById(id);
        return  ResponseEntity.ok(new JSuccessDataResponse<>(anyInterestById));

    }
}
