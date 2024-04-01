package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.core.exception.education.EducationDomainException;
import az.rock.flyjob.js.domain.core.exception.education.EducationNotFoundException;
import az.rock.flyjob.js.domain.presentation.dto.criteria.EducationCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleAnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractEducationQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EducationQueryHandler implements AbstractEducationQueryHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter;

    private final List<AccessModifier> accessModifiers = List.of(AccessModifier.values());

    public EducationQueryHandler(AbstractSecurityContextHolder securityContextHolder, AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.educationQueryRepositoryAdapter = educationQueryRepositoryAdapter;
    }

    private SimplePageableResponse simplePageableResponse(SimplePageableRequest pageableRequest, List educationsResponseList) {
        var hasMore = educationsResponseList.size() > pageableRequest.getSize();
        if (hasMore) educationsResponseList.remove(educationsResponseList.size() - 1);
        return SimplePageableResponse.of(pageableRequest.getSize(), pageableRequest.getPage(), hasMore, educationsResponseList);
    }

    @Override
    public SimplePageableResponse<MyEducationResponseModel> queryAllMyEducations(SimplePageableRequest pageableRequest) throws EducationDomainException {
        var currentResumeId = securityContextHolder.availableResumeID();
        var educationCriteria = EducationCriteria.builder().resumeID(currentResumeId.getRootID()).build();
        var myEducationsRootList = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        var myEducationsResponseList = myEducationsRootList.stream().map(MyEducationResponseModel::of).toList();
        return simplePageableResponse(pageableRequest, myEducationsResponseList);
    }

    @Override
    public SimplePageableResponse<AnyEducationResponseModel> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) throws EducationDomainException {
        var educationCriteria = EducationCriteria.builder().resumeID(targetResumeId).build();
        var anyEducationRootList = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        var anyEducationResponseList = anyEducationRootList.stream().map(AnyEducationResponseModel::of).toList();
        return simplePageableResponse(pageableRequest, anyEducationResponseList);
    }

    @Override
    public SimplePageableResponse<SimpleMyEducationResponseModel> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) throws EducationDomainException {
        var currentResumeId = securityContextHolder.availableResumeID();
        var educationCriteria = EducationCriteria.builder().resumeID(currentResumeId.getRootID()).build();
        var simpleEducationRoots = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        var simpleEducationResponseList = simpleEducationRoots.stream().map(SimpleMyEducationResponseModel::of).toList();
        return simplePageableResponse(pageableRequest, simpleEducationResponseList);
    }

    @Override
    public SimplePageableResponse<SimpleAnyEducationResponseModel> queryAllAnySimpleEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) throws EducationDomainException {
        var educationCriteria = EducationCriteria.builder().resumeID(targetResumeId).build();
        var anySimpleEducationRoots = educationQueryRepositoryAdapter.fetchAllEducations(educationCriteria, pageableRequest);
        var simpleAnyEducationResponseList = anySimpleEducationRoots.stream().map(SimpleAnyEducationResponseModel::of).toList();
        return simplePageableResponse(pageableRequest, simpleAnyEducationResponseList);
    }

    @Override
    public MyEducationResponseModel findMyEducationById(UUID id) throws EducationDomainException {
        var currentResumeId = securityContextHolder.availableResumeID();
        var criteria = EducationCriteria.builder().resumeID(currentResumeId.getRootID()).educationId(id).build();
        var myEducationRoot = educationQueryRepositoryAdapter.fetchEducation(criteria).orElseThrow(EducationNotFoundException::new);
        return MyEducationResponseModel.of(myEducationRoot);
    }

    @Override
    public AnyEducationResponseModel findAnyEducationById(UUID id) throws EducationDomainException {
        var criteria = EducationCriteria.builder().educationId(id).accessModifiers(accessModifiers).build();
        var anyEducation = educationQueryRepositoryAdapter.fetchEducation(criteria).orElseThrow(EducationNotFoundException::new);
        return AnyEducationResponseModel.of(anyEducation);
    }
}
