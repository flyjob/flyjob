package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractExperienceQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractExperienceQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExperienceQueryDomainPresentationService implements AbstractExperienceQueryDomainPresentationService {

    private final AbstractExperienceQueryHandler abstractExperienceQueryHandler;

    public ExperienceQueryDomainPresentationService(AbstractExperienceQueryHandler abstractExperienceQueryHandler) {
        this.abstractExperienceQueryHandler = abstractExperienceQueryHandler;
    }

    @Override
    public SimplePageableResponse<MyExperienceResponseModel> allMyExperiences(SimplePageableRequest pageableRequest) {
        return abstractExperienceQueryHandler.allMyExperiences(pageableRequest);
    }

    @Override
    public SimplePageableResponse<AnyExperienceResponseModel> allAnyExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return abstractExperienceQueryHandler.allAnyExperiences(targetResumeId,pageableRequest);
    }

    @SneakyThrows
    @Override
    public MyExperienceResponseModel myExperienceById(UUID id) {
        return abstractExperienceQueryHandler.myExperienceById(id);
    }

    @Override
    public SimplePageableResponse<SimpleMyExperienceResponseModel> allMySimpleExperiences(SimplePageableRequest pageableRequest) {
        return abstractExperienceQueryHandler.allMySimpleExperiences(pageableRequest);
    }

    @Override
    public SimplePageableResponse<SimpleAnyExperienceResponseModel> allAnySimpleExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return abstractExperienceQueryHandler.allAnySimpleExperiences(targetResumeId,pageableRequest);
    }
    @SneakyThrows
    @Override
    public AnyExperienceResponseModel anyExperienceById(UUID id) {
        return abstractExperienceQueryHandler.anyExperienceById(id);
    }
}
