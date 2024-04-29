package az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.AnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.MyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleAnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleMyProjectResponseModel;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional(readOnly = true)
public interface AbstractProjectQueryDomainPresentationService {
    MyProjectResponseModel findMyProjectById(UUID id);

    SimplePageableResponse<MyProjectResponseModel> queryAllMyProjects(SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleMyProjectResponseModel> queryAllMySimpleProjects(SimplePageableRequest pageableRequest);

    SimplePageableResponse<AnyProjectResponseModel> queryAllAnyProjects(UUID targetResumeId, SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleAnyProjectResponseModel> queryAllAnySimpleProjects(UUID targetResumeId, SimplePageableRequest pageableRequest);

    AnyProjectResponseModel findAnyProjectById(UUID id);
}
