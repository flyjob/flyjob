package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractInterestQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractInterestQueryDomainPresentationService;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class InterestQueryDomainPresentationService implements AbstractInterestQueryDomainPresentationService {
    private final AbstractInterestQueryHandler interestQueryHandler;

    public InterestQueryDomainPresentationService(AbstractInterestQueryHandler interestQueryHandler) {
        this.interestQueryHandler = interestQueryHandler;
    }


    @Override
    @SneakyThrows
    public MyInterestResponseModel findMyInterestById(UUID id) {
        return this.interestQueryHandler.findMyInterestById(id);
    }

    @Override
    @SneakyThrows
    public SimplePageableResponse<MyInterestResponseModel> queryAllMyInterests(SimplePageableRequest pageableRequest) {
        return this.interestQueryHandler.queryAllMyInterests(pageableRequest);
    }

    @Override
    @SneakyThrows
    public SimplePageableResponse<SimpleMyInterestResponseModel> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) {
        return this.interestQueryHandler.queryAllMySimpleInterests(pageableRequest);
    }
    @SneakyThrows
    @Override
    public SimplePageableResponse<AnyInterestResponseModel> queryAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageable) {
        return this.interestQueryHandler.findAllAnyInterests(targetResumeId, pageable);
    }

    @SneakyThrows
    @Override
    public SimplePageableResponse<SimpleAnyInterestResponseModel> queryAllAnySimpleInterests(UUID targetResumeId, SimplePageableRequest pageable) {
        return this.interestQueryHandler.findAllAnySimpleInterest(targetResumeId, pageable);
    }

    @SneakyThrows
    @Override
    public AnyInterestResponseModel findAnyInterestById(UUID Id) {
        return this.interestQueryHandler.findAnyById(Id);
    }
}
