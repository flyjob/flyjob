package az.rock.flyjob.js.domain.presentation.handler.query.concretes;


import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.AnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.MyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleAnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleMyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractProjectQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractProjectQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProjectQueryHandler implements AbstractProjectQueryHandler {
    private final List<AccessModifier> modifierList = List.of(AccessModifier.values());
    private  final AbstractSecurityContextHolder contextHolder;
    private final AbstractProjectQueryRepositoryAdapter projectQueryRepositoryAdapter;

    public ProjectQueryHandler(AbstractSecurityContextHolder contextHolder, AbstractProjectQueryRepositoryAdapter projectQueryRepositoryAdapter) {
        this.contextHolder = contextHolder;
        this.projectQueryRepositoryAdapter = projectQueryRepositoryAdapter;
    }

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
