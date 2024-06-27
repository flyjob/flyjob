package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.core.exception.experience.ExperienceNotFoundException;
import az.rock.flyjob.js.domain.presentation.dto.criteria.ExperienceCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractExperienceQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractExperienceQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ExperienceQueryHandler implements AbstractExperienceQueryHandler {
    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractExperienceQueryRepositoryAdapter abstractExperienceQueryHandler;

    private List<AccessModifier> mockAccessModifiers = List.of(AccessModifier.values());

    public ExperienceQueryHandler(AbstractSecurityContextHolder securityContextHolder, AbstractExperienceQueryRepositoryAdapter abstractExperienceQueryHandler) {
        this.securityContextHolder = securityContextHolder;
        this.abstractExperienceQueryHandler = abstractExperienceQueryHandler;
    }

    @Override
    public SimplePageableResponse<MyExperienceResponseModel> allMyExperiences(SimplePageableRequest pageableRequest) {
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = ExperienceCriteria.Builder.builder().resumeID(resumeId).build();
        var experiences = abstractExperienceQueryHandler.fetchAllExperiences(criteria,pageableRequest)
                .stream()
                .map(MyExperienceResponseModel::of)
                .collect(Collectors.toList());
        var payload = convertSimplePageableResponse(experiences,pageableRequest);
        return payload;
    }

    @Override
    public SimplePageableResponse<AnyExperienceResponseModel> allAnyExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var criteria = ExperienceCriteria.Builder.builder().resumeID(ResumeID.of(targetResumeId)).accessModifiers(mockAccessModifiers).build();
        var experiences = abstractExperienceQueryHandler.fetchAllExperiences(criteria,pageableRequest)
                .stream()
                .map(AnyExperienceResponseModel::of)
                .collect(Collectors.toList());
        var payload =  convertSimplePageableResponse(experiences,pageableRequest);
        return payload;
    }

    @Override
    public MyExperienceResponseModel myExperienceById(UUID id) throws ExperienceNotFoundException{
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = ExperienceCriteria.Builder.builder().id(ExperienceID.of(id)).resumeID(resumeId).build();
        var experience = abstractExperienceQueryHandler.fetchExperienceById(criteria);
        var payload =  MyExperienceResponseModel.of(experience.orElseThrow(ExperienceNotFoundException::new));
        return payload;
    }

    @Override
    public SimplePageableResponse<SimpleMyExperienceResponseModel> allMySimpleExperiences(SimplePageableRequest pageableRequest) {
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = ExperienceCriteria.Builder.builder().resumeID(resumeId).build();
        var experiences = abstractExperienceQueryHandler.fetchAllExperiences(criteria,pageableRequest)
                .stream()
                .map(SimpleMyExperienceResponseModel::of)
                .collect(Collectors.toList());
        var payload = convertSimplePageableResponse(experiences,pageableRequest);
        return payload;
    }

    @Override
    public SimplePageableResponse<SimpleAnyExperienceResponseModel> allAnySimpleExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var criteria = ExperienceCriteria.Builder.builder().resumeID(ResumeID.of(targetResumeId)).accessModifiers(mockAccessModifiers).build();
        var experiences = abstractExperienceQueryHandler.fetchAllExperiences(criteria,pageableRequest)
                .stream()
                .map(SimpleAnyExperienceResponseModel::of)
                .collect(Collectors.toList());
        var payload =  convertSimplePageableResponse(experiences,pageableRequest);
        return payload;
    }

    @Override
    public AnyExperienceResponseModel anyExperienceById(UUID id) throws ExperienceNotFoundException {
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = ExperienceCriteria.Builder.builder().id(ExperienceID.of(id)).resumeID(resumeId).accessModifiers(mockAccessModifiers).build();
        var experience = abstractExperienceQueryHandler.fetchExperienceById(criteria);
        var payload =  AnyExperienceResponseModel.of(experience.orElseThrow(ExperienceNotFoundException::new));
        return payload;
    }

    private SimplePageableResponse convertSimplePageableResponse(List courses,SimplePageableRequest simplePageableRequest){
        Boolean hasMore = courses.size()  > simplePageableRequest.getSize();
        if(hasMore)courses.remove(courses.size()-1);
        return SimplePageableResponse.of(simplePageableRequest.getSize(), simplePageableRequest.getPage(),hasMore,courses);
    }
}
