package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleAnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractEducationQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractEducationQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EducationQueryDomainPresentationService implements AbstractEducationQueryDomainPresentationService {

    private final AbstractEducationQueryHandler abstractEducationQueryHandler;


    public EducationQueryDomainPresentationService(AbstractEducationQueryHandler abstractEducationQueryHandler) {
        this.abstractEducationQueryHandler = abstractEducationQueryHandler;
    }

    @Override
    @SneakyThrows
    public SimplePageableResponse<MyEducationResponseModel> queryAllMyEducations(SimplePageableRequest pageableRequest) {
        return this.abstractEducationQueryHandler.queryAllMyEducations(pageableRequest);
    }

    @Override
    @SneakyThrows
    public SimplePageableResponse<AnyEducationResponseModel> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return this.abstractEducationQueryHandler.queryAllAnyEducations(targetResumeId, pageableRequest);
    }

    @Override
    @SneakyThrows
    public SimplePageableResponse<SimpleMyEducationResponseModel> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) {
        return this.abstractEducationQueryHandler.queryAllMySimpleEducations(pageableRequest);
    }


    @Override
    @SneakyThrows
    public SimplePageableResponse<SimpleAnyEducationResponseModel> queryAllAnySimpleEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return this.abstractEducationQueryHandler.queryAllAnySimpleEducations(targetResumeId, pageableRequest);
    }


    @Override
    @SneakyThrows
    public MyEducationResponseModel findMyEducationById(UUID id) {
        return this.abstractEducationQueryHandler.findMyEducationById(id);
    }

    @Override
    @SneakyThrows
    public AnyEducationResponseModel findAnyEducationById(UUID id) {
        return this.abstractEducationQueryHandler.findAnyEducationById(id);
    }
}
