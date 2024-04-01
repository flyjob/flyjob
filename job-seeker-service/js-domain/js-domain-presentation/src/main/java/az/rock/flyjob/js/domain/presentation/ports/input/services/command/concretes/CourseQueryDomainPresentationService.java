package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
public class CourseQueryDomainPresentationService implements AbstractCourseQueryDomainPresentationService {

    private final AbstractCourseQueryHandler queryHandler;

    public CourseQueryDomainPresentationService(AbstractCourseQueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    @Override
    public SimplePageableResponse<SimpleAnyCourseResponseModel> allAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return queryHandler.allAnySimpleCourses(targetResumeId, pageableRequest);
    }

    @Override
    public SimplePageableResponse<SimpleMyCourseResponseModel> allMySimpleCourses(SimplePageableRequest simplePageableRequest) {
        return queryHandler.allMySimpleCourses(simplePageableRequest);
    }

    @SneakyThrows
    @Override
    public AnyCourseResponseModel findAnyCourse(UUID uuid) {
        return queryHandler.anyCourseById(uuid);
    }

    @Override
    public SimplePageableResponse<MyCourseResponseModel> allMyCourses(SimplePageableRequest pageableRequest) {
        return queryHandler.allMyCourses(pageableRequest);
    }

    @Override
    public SimplePageableResponse<AnyCourseResponseModel> allAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return queryHandler.allAnyCourses(targetResumeId, pageableRequest);
    }

    @SneakyThrows
    @Override
    public MyCourseResponseModel myCourseById(UUID id) {
        return queryHandler.myCourseById(id);
    }
}