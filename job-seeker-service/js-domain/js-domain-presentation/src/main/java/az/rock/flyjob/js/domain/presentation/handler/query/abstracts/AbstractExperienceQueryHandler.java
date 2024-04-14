package az.rock.flyjob.js.domain.presentation.handler.query.abstracts;

import az.rock.flyjob.js.domain.core.exception.experience.ExperienceNotFoundException;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractExperienceQueryHandler {
    SimplePageableResponse<MyExperienceResponseModel> allMyExperiences(SimplePageableRequest pageableRequest);

    SimplePageableResponse<AnyExperienceResponseModel> allAnyExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest);

    MyExperienceResponseModel myExperienceById(UUID id) throws ExperienceNotFoundException;

    SimplePageableResponse<SimpleMyExperienceResponseModel> allMySimpleExperiences(SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleAnyExperienceResponseModel> allAnySimpleExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest);

    AnyExperienceResponseModel anyExperienceById(UUID id) throws ExperienceNotFoundException;
}
