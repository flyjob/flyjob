package az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.SimplePageableRequest;

import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@InputPort
@Transactional(readOnly = true)
public interface AbstractInterestQueryDomainPresentationService {

    MyInterestResponseModel findMyInterestById(UUID id);

    SimplePageableResponse<MyInterestResponseModel> queryAllMyInterests(SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleMyInterestResponseModel> queryAllMySimpleInterests(SimplePageableRequest pageableRequest);

    SimplePageableResponse<AnyInterestResponseModel> queryAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleAnyInterestResponseModel> queryAllAnySimpleInterests(UUID targetResumeId, SimplePageableRequest pageableRequest);

    AnyInterestResponseModel findAnyInterestById(UUID id);

}
