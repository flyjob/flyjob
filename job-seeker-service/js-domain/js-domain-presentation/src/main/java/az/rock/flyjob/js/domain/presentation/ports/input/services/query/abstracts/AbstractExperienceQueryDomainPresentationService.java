package az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
//@Transactional(readOnly = true)
public interface AbstractExperienceQueryDomainPresentationService {
    SimplePageableResponse<MyExperienceResponseModel> allMyExperiences(SimplePageableRequest pageableRequest);

    SimplePageableResponse<AnyExperienceResponseModel> allAnyExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest);

    MyExperienceResponseModel myExperienceById(UUID id);

    SimplePageableResponse<SimpleMyExperienceResponseModel> allMySimpleExperiences(SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleAnyExperienceResponseModel> allAnySimpleExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest);

    AnyExperienceResponseModel anyExperienceById(UUID id);

}
