package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.core.exception.course.CourseNotFoundException;
import az.rock.flyjob.js.domain.presentation.dto.criteria.CourseCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractCourseQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class CourseQueryHandler implements AbstractCourseQueryHandler{


    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter;

    private List<AccessModifier> mockAccessModifiers = List.of(AccessModifier.values());

    public CourseQueryHandler(AbstractSecurityContextHolder securityContextHolder, AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.courseQueryRepositoryAdapter = courseQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<MyCourseResponseModel> allMyCourses(SimplePageableRequest pageableRequest) {
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = CourseCriteria.Builder.builder().resumeID(resumeId).build();
        var courses = courseQueryRepositoryAdapter.fetchAllCourses(criteria,pageableRequest)
                .stream()
                .map(MyCourseResponseModel::of)
                .collect(Collectors.toList());
        var payload = convertSimplePageableResponse(courses,pageableRequest);
        return payload;

    }

    @Override
    public SimplePageableResponse<AnyCourseResponseModel> allAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var criteria = CourseCriteria.Builder.builder().resumeID(ResumeID.of(targetResumeId)).accessModifiers(mockAccessModifiers).build();
        var courses = courseQueryRepositoryAdapter.fetchAllCourses(criteria,pageableRequest)
                .stream()
                .map(AnyCourseResponseModel::of)
                .collect(Collectors.toList());
        var payload =  convertSimplePageableResponse(courses,pageableRequest);
        return payload;
    }
    @Override
    public MyCourseResponseModel myCourseById(UUID id) throws CourseNotFoundException {
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = CourseCriteria.Builder.builder().id(CourseID.of(id)).resumeID(resumeId).build();
        var course = courseQueryRepositoryAdapter.fetchCourseById(criteria);
        var payload =  MyCourseResponseModel.of(course.orElseThrow(CourseNotFoundException::new));
        return payload;
    }


    @Override
    public AnyCourseResponseModel anyCourseById(UUID uuid) throws CourseNotFoundException {
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = CourseCriteria.Builder.builder().id(CourseID.of(uuid)).resumeID(resumeId).accessModifiers(mockAccessModifiers).build();
        var course = courseQueryRepositoryAdapter.fetchCourseById(criteria);
        var payload =  AnyCourseResponseModel.of(course.orElseThrow(CourseNotFoundException::new));
        return payload;
    }

    @Override
    public SimplePageableResponse<SimpleMyCourseResponseModel> allMySimpleCourses(SimplePageableRequest simplePageableRequest) {
        var resumeId = securityContextHolder.availableResumeID();
        var criteria = CourseCriteria.Builder.builder().resumeID(resumeId).build();
        var courses = courseQueryRepositoryAdapter.fetchAllCourses(criteria,simplePageableRequest)
                .stream()
                .map(SimpleMyCourseResponseModel::of)
                .collect(Collectors.toList());
        var payload = convertSimplePageableResponse(courses,simplePageableRequest);
        return payload;
    }

    @Override
    public SimplePageableResponse<SimpleAnyCourseResponseModel> allAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var criteria = CourseCriteria.Builder.builder().resumeID(ResumeID.of(targetResumeId)).accessModifiers(mockAccessModifiers).build();
        var courses = courseQueryRepositoryAdapter.fetchAllCourses(criteria,pageableRequest)
                .stream()
                .map(SimpleAnyCourseResponseModel::of)
                .collect(Collectors.toList());
        var payload =  convertSimplePageableResponse(courses,pageableRequest);
        return payload;
    }

    private SimplePageableResponse convertSimplePageableResponse(List courses,SimplePageableRequest simplePageableRequest){
        Boolean hasMore = courses.size()  > simplePageableRequest.getSize();
        if(hasMore)courses.remove(courses.size()-1);
        return SimplePageableResponse.of(simplePageableRequest.getSize(), simplePageableRequest.getPage(),hasMore,courses);
    }
}

