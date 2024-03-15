package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractEducationQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EducationQueryDomainPresentationService implements AbstractEducationQueryDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEducationQueryRepositoryAdapter educationQueryRepositoryAdapter;

    public EducationQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder, AbstractEducationQueryRepositoryAdapter abstractEducationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.educationQueryRepositoryAdapter = abstractEducationQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<MyEducationResponseModel> queryAllMyEducations(SimplePageableRequest pageableRequest) {
        var resumeId = securityContextHolder.availableResumeID();
        var listOfMyEducations = educationQueryRepositoryAdapter.findAllMyEducations(resumeId,pageableRequest);
        return null;
    }

    @Override
    public SimplePageableResponse<AnyEducationResponseModel> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var listOfAnyEducations = educationQueryRepositoryAdapter.findAllAnyEducations(targetResumeId,pageableRequest);
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyEducationResponseModel> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) {
        var resumeId = securityContextHolder.availableResumeID();
        var allMySimpleEducations = educationQueryRepositoryAdapter.findAllMySimpleEducations(resumeId,pageableRequest);
        return null;
    }
}
