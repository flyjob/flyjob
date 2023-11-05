package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractTestQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.compose.user.UserCompose;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis.AbstractUserComposeQueryBatisRepository;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.jooq.AbstractUserJOOQRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class TestQueryRepositoryAdapter implements AbstractTestQueryRepositoryAdapter {
    private final AbstractUserComposeQueryBatisRepository abstractUserComposeQueryBatisRepository;
    private final AbstractUserJOOQRepository abstractUserJOOQRepository;

    public TestQueryRepositoryAdapter(AbstractUserComposeQueryBatisRepository abstractUserComposeQueryBatisRepository, AbstractUserJOOQRepository abstractUserJOOQRepository) {
        this.abstractUserComposeQueryBatisRepository = abstractUserComposeQueryBatisRepository;
        this.abstractUserJOOQRepository = abstractUserJOOQRepository;
    }

    public Optional<UserCompose> case1(UUID userId){
        var response1 = this.abstractUserJOOQRepository.findUserById(userId);
        var response = abstractUserComposeQueryBatisRepository.findUserProfileComposeByUserId(userId);
        return Optional.ofNullable(response);
    }
}
