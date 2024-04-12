package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractExperienceQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;

import java.util.UUID;

public class ExperienceQueryDomainPresentationService implements AbstractExperienceQueryDomainPresentationService {

    @Override
    public SimplePageableResponse<MyExperienceResponseModel> queryAllMyExperiences(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<AnyExperienceResponseModel> queryAllAnyExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public MyExperienceResponseModel findMyExperienceById(UUID id) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyExperienceResponseModel> queryAllMySimpleExperiences(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleAnyExperienceResponseModel> queryAllAnySimpleExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public AnyExperienceResponseModel findAnyExperienceById(UUID id) {
        return null;
    }
}
