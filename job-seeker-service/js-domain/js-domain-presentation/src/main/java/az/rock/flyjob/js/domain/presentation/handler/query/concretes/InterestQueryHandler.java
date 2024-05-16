package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.core.exception.interest.InterestNotFound;
import az.rock.flyjob.js.domain.core.exception.interest.InterestOverLimit;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractInterestQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class InterestQueryHandler implements AbstractInterestQueryHandler {
    private final List<AccessModifier> modifierList = List.of(AccessModifier.values());
    private final AbstractSecurityContextHolder contextHolder;
    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;

    public InterestQueryHandler(AbstractSecurityContextHolder contextHolder,
                                AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter) {
        this.contextHolder = contextHolder;
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest) throws Exception {
        final InterestCriteria criteria = toCriteria(ResumeID.of(targetResumeId), null, modifierList);
        var allAnyInterestsRoot = this.interestQueryRepositoryAdapter.fetchAllAnyInterests(criteria, pageableRequest);
        var allAnyInterest = allAnyInterestsRoot.stream()
                .map(AnyInterestResponseModel::of)
                .collect(Collectors.toList());
        return convertResponse(allAnyInterest, pageableRequest);

    }


    @Override
    public SimplePageableResponse<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId, SimplePageableRequest pageableRequest) throws Exception {
        final InterestCriteria criteria = toCriteria(ResumeID.of(targetResumeId), null, modifierList);
        var allAnySimpleInterest = this.interestQueryRepositoryAdapter.fetchAllAnySimpleInterest(criteria, pageableRequest);
            var allAnyInterest = allAnySimpleInterest.stream()
                    .map(SimpleAnyInterestResponseModel::of)
                    .collect(Collectors.toList());
            return convertResponse(allAnyInterest, pageableRequest);

    }

    @Override
    public AnyInterestResponseModel findAnyById(UUID id) throws InterestNotFound {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID, id, modifierList);
        var anyById = this.interestQueryRepositoryAdapter.fetchAnyById(interestCriteria);
        if (anyById.isPresent()) {
            return AnyInterestResponseModel.of(anyById.get());
        } else throw new InterestNotFound();
    }

    @Override
    public MyInterestResponseModel findMyInterestById(UUID id) throws InterestNotFound {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID, id, null);
        var myInterest = this.interestQueryRepositoryAdapter.findMyInterestById(interestCriteria);
        return myInterest.map(MyInterestResponseModel::of)
                .orElseThrow(InterestNotFound::new);
    }

    @Override
    public SimplePageableResponse<MyInterestResponseModel> queryAllMyInterests(SimplePageableRequest pageableRequest) throws InterestOverLimit {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID, null, null);
        var myInterest = this.interestQueryRepositoryAdapter.queryAllMyInterests(interestCriteria, pageableRequest).stream()
                .map(MyInterestResponseModel::of).collect(Collectors.toList());
        return convertResponse(myInterest, pageableRequest);
    }

    @Override
    public SimplePageableResponse<SimpleMyInterestResponseModel> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) throws InterestOverLimit {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID, null, null);
        var myInterest = this.interestQueryRepositoryAdapter.queryAllMySimpleInterests(interestCriteria, pageableRequest).stream()
                .map(SimpleMyInterestResponseModel::of)
                .collect(Collectors.toList());
        return convertResponse(myInterest, pageableRequest);
    }


    //------------------------------------------------------------------------


    public InterestCriteria toCriteria(ResumeID resumeId, UUID id, List<AccessModifier> modifier) {
        return InterestCriteria.Builder.builder().
                resume(resumeId)
                .id(id)
                .accessModifier(modifier)
                .build();

    }

    public SimplePageableResponse convertResponse(List list, SimplePageableRequest pageableRequest) {
        boolean hasMore = list.size() > pageableRequest.getSize();
        if (hasMore){
            list.remove(list.size()-1);
        }
        return SimplePageableResponse.of(pageableRequest.getSize(), pageableRequest.getPage(), hasMore, list);

    }
}
