package az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleAnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleMyContactResponseModel;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional(readOnly = true)
public interface AbstractContactQueryDomainPresentationService {
    SimplePageableResponse<AnyContactResponseModel> queryAllAnyContacts(SimplePageableRequest simplePageableRequest);
    SimplePageableResponse<MyContactResponseModel> queryAllMyContacts(SimplePageableRequest simplePageableRequest);
    SimplePageableResponse<SimpleMyContactResponseModel> queryAllMySimpleContacts(SimplePageableRequest simplePageableRequest);
    SimplePageableResponse<SimpleAnyContactResponseModel> queryAllAnySimpleContacts(UUID targetResumeID , SimplePageableRequest simplePageableRequest);
    MyContactResponseModel findMyContactById(UUID uuid);
    AnyContactResponseModel findAnyContactById(UUID uuid);

 }
