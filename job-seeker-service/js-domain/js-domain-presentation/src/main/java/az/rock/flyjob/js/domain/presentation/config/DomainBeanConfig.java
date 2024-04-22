package az.rock.flyjob.js.domain.presentation.config;

import az.rock.flyjob.js.domain.core.service.abstracts.AbstractInterestDomainService;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractResumeDomainService;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractSkillDomainService;
import az.rock.flyjob.js.domain.core.service.concretes.InterestDomainService;
import az.rock.flyjob.js.domain.core.service.concretes.ResumeDomainService;
import az.rock.flyjob.js.domain.core.service.concretes.SkillDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeanConfig {

    @Bean
    AbstractInterestDomainService interestDomainService() {
        return new InterestDomainService();
    }

    @Bean
    public AbstractSkillDomainService skillDomainService() {
        return new SkillDomainService();
    }

    @Bean
    public AbstractResumeDomainService resumeDomainService() {
        return new ResumeDomainService();
    }
}
