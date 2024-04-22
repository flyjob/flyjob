package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface AbstractInterestQueryBatisRepository {

    Optional<AnyInterestResponseModel> findAnyInterestById(
            @Param(value = "resumeId") UUID resumeId,
            @Param(value = "interestId") UUID interestId,
            @Param(value = "access") List<AccessModifier> access);


    List<AnyInterestResponseModel> findAllAnyInterests(
            @Param(value = "resumeId") UUID targetResumeId,
            @Param(value = "access") List<AccessModifier> access,
            @Param(value = "pageable") SimplePageableRequest pageable);

    List<SimpleAnyInterestResponseModel> findAllAnySimpleInterests(
            @Param(value = "resumeId") UUID targetResumeId,
            @Param(value = "access") List<AccessModifier> access,
            @Param(value = "pageable") SimplePageableRequest pageable);



}
