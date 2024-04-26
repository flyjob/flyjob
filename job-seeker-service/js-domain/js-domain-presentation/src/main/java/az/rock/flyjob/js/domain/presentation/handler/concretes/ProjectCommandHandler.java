package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
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

import java.util.Comparator;
import java.util.List;
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
        var resumeId = this.securityContextHolder.availableResumeID();
        var projectRoot = this.projectQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeId, request.getTargetId());
        var updatedRoot = this.projectDomainMapper.toExistRoot(projectRoot.get(), request.getModel());
        this.projectCommandRepositoryAdapter.update(updatedRoot);
        var payload = this.projectDomainMapper.toPayload(updatedRoot);
        return ProjectMergeEvent.of(payload);
    }

    @Override
    public ProjectDeleteEvent delete(UUID id) {
        var resumeID = securityContextHolder.availableResumeID();
        var projectDb = projectQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeID, id);
        projectCommandRepositoryAdapter.inActive(projectDb.get());
        return ProjectDeleteEvent.of(id);
    }

    @Override
    public ProjectMergeEvent reorder(ReorderCommandModel commandModel)  {
        var resumeId = securityContextHolder.availableResumeID();
        List<ProjectRoot> projects = projectQueryRepositoryAdapter.findAllByPID(resumeId);
        var project = projects.stream().filter(
                e -> e.getRootID().getAbsoluteID().equals(commandModel.getTargetId())
        ).findFirst();
        var reOrderNumber = commandModel.getOrderNumber();
        if (commandModel.getOrderNumber() > project.get().getOrderNumber()) ++reOrderNumber;
        project.get().changeOrderNumber(reOrderNumber)  ;
        projects.stream()
                .filter(e -> e.getOrderNumber() >= project.get().getOrderNumber() && !e.equals(e))
                .forEach(e -> e.changeOrderNumber(e.getOrderNumber() + 1));
        int orderCounter = 1;
        for (ProjectRoot projectRoot : projects.stream()
                .sorted(Comparator.comparingInt(ProjectRoot::getOrderNumber))
                .toList()) {
            projectRoot.changeOrderNumber(orderCounter++);
        }
        projectCommandRepositoryAdapter.updateAll(projects);
        return ProjectMergeEvent.of(
                ProjectPayload.Builder
                        .builder()
                        .id(commandModel.getTargetId())
                        .build());
    }
}
