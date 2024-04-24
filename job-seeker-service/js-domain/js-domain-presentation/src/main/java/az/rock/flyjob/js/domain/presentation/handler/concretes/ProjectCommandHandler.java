package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractProjectCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractProjectDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractProjectCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractProjectQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.command.create.ProjectMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.ProjectDeleteEvent;
import com.intellibucket.lib.payload.payload.command.ProjectPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ProjectCommandHandler implements AbstractProjectCommandHandler<AbstractDomainEvent<?>> {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractProjectCommandRepositoryAdapter projectCommandRepositoryAdapter;
    private final AbstractProjectQueryRepositoryAdapter projectQueryRepositoryAdapter;
    private final AbstractProjectDomainMapper projectDomainMapper;

    public ProjectCommandHandler(AbstractSecurityContextHolder securityContextHolder
            , AbstractProjectCommandRepositoryAdapter projectCommandRepositoryAdapter
            , AbstractProjectQueryRepositoryAdapter projectQueryRepositoryAdapter
            , AbstractProjectDomainMapper projectDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.projectCommandRepositoryAdapter = projectCommandRepositoryAdapter;
        this.projectQueryRepositoryAdapter = projectQueryRepositoryAdapter;
        this.projectDomainMapper = projectDomainMapper;
    }

    @Override
    public AbstractDomainEvent<ProjectPayload> create(CreateRequest<ProjectCommandModel> request) {
        var resumeId = this.securityContextHolder.availableResumeID();
        var projectRoot = this.projectDomainMapper.toNewRoot(resumeId, request.getModel());
        var optionalProjectRoot = this.projectCommandRepositoryAdapter.create(projectRoot);
        var payload = this.projectDomainMapper.toPayload(optionalProjectRoot.get());
        return ProjectMergeEvent.of(payload);
    }

    @Override
    public ProjectMergeEvent update(UpdateRequest<ProjectCommandModel> request) {
        return null;
    }

    @Override
    public ProjectDeleteEvent delete(UUID id) {

        return null;
    }

    @Override
    public ProjectMergeEvent reorder(ProjectCommandModel commandModel) {
        return null;
    }
}
