package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.AnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.MyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleAnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleMyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractProjectQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractProjectQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectQueryDomainPresentationService implements AbstractProjectQueryDomainPresentationService {
    private final AbstractProjectQueryHandler projectQueryHandler;

    public ProjectQueryDomainPresentationService(AbstractProjectQueryHandler projectQueryHandler) {
        this.projectQueryHandler = projectQueryHandler;
    }

    @Override
    public MyProjectResponseModel findMyProjectById(UUID id) {
        return null;
    }

    @Override
    public SimplePageableResponse<MyProjectResponseModel> queryAllMyProjects(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyProjectResponseModel> queryAllMySimpleProjects(SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<AnyProjectResponseModel> queryAllAnyProjects(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleAnyProjectResponseModel> queryAllAnySimpleProjects(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public AnyProjectResponseModel findAnyProjectById(UUID id) {
        return null;
    }
}
