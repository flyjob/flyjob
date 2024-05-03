package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.exception.interest.InterestOverLimit;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.flyjob.js.domain.presentation.dto.criteria.ProjectCriteria;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ProjectID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AbstractProjectQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<ProjectRoot, ProjectID,ResumeID> {
    Optional<ProjectRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID projectId);
    Optional<ProjectRoot> fetchAnyById(ProjectCriteria criteria) ;


    List<ProjectRoot> fetchAllAnyProjectIs(ProjectCriteria criteria, SimplePageableRequest pageableRequest);

    List<ProjectRoot> fetchAllAnySimpleProjectI(ProjectCriteria criteria,SimplePageableRequest request);

    Optional<ProjectRoot> findMyProjectIById(ProjectCriteria criteria);

    List<ProjectRoot> queryAllMyProjectIs(ProjectCriteria criteria, SimplePageableRequest pageableRequest);

    List<ProjectRoot> queryAllMySimpleProjectIs(ProjectCriteria criteria,SimplePageableRequest pageableRequest);
    //--------------------------------Hibernate queries-----------------------------------
    Optional<ProjectRoot> findOwnByID(ResumeID parentID, ProjectID rootId, List<AccessModifier> accessModifiers);

    List<ProjectRoot> findAllByPID(ResumeID parentID, List<AccessModifier> accessModifiers);

    Optional<Integer> getLimit(ResumeID resumeID);
}
