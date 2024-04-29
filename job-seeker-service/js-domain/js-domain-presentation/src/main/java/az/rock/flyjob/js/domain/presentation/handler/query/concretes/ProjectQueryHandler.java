package az.rock.flyjob.js.domain.presentation.handler.query.concretes;


import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.AnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.MyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleAnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleMyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractProjectQueryHandler;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProjectQueryHandler implements AbstractProjectQueryHandler {
    @Override
    public SimplePageableResponse<AnyProjectResponseModel> findAllAnyProjects(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleAnyProjectResponseModel> findAllAnySimpleProject(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public AnyProjectResponseModel findAnyById(UUID id) {
        return null;
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
}
