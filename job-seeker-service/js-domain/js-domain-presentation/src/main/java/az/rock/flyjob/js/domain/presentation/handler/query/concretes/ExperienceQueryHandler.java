package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractExperienceQueryHandler;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ExperienceQueryHandler implements AbstractExperienceQueryHandler {
    private final AbstractSecurityContextHolder securityContextHolder;

    @Override
    public SimplePageableResponse<MyExperienceResponseModel> allMyExperiences(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<AnyExperienceResponseModel> allAnyExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public MyExperienceResponseModel myExperienceById(UUID id) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyExperienceResponseModel> allMySimpleExperiences(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleAnyExperienceResponseModel> allAnySimpleExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public AnyExperienceResponseModel anyExperienceById(UUID id) {
        return null;
    }
}
