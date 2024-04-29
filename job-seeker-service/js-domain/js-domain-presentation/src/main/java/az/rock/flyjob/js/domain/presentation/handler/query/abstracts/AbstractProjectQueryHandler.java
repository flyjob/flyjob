package az.rock.flyjob.js.domain.presentation.handler.query.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.AnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.MyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleAnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleMyProjectResponseModel;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractProjectQueryHandler {
    SimplePageableResponse<AnyProjectResponseModel> findAllAnyProjects(UUID targetResumeId, SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleAnyProjectResponseModel> findAllAnySimpleProject(UUID targetResumeId, SimplePageableRequest pageableRequest);

    AnyProjectResponseModel findAnyById(UUID id);

    MyProjectResponseModel findMyProjectById(UUID id);

    SimplePageableResponse<MyProjectResponseModel> queryAllMyProjects(SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleMyProjectResponseModel> queryAllMySimpleProjects(SimplePageableRequest pageableRequest);
}
