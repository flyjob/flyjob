package az.rock.flyjob.gateway.locator.filter.concretes;

import az.rock.flyjob.gateway.locator.filter.abstracts.AbstractGAuthorizationFilter;
import az.rock.lib.jexception.JSecurityException;
import az.rock.message.MessageProvider;
import az.rock.spring.security.core.JwtService;
import az.rock.spring.security.model.HeaderModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GAuthorizationFilter extends AbstractGAuthorizationFilter {

    private final MessageProvider messageProvider;
    private final JwtService jwtService;

    public GAuthorizationFilter(MessageProvider messageProvider, JwtService jwtService) {
        this.messageProvider = messageProvider;
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        log.debug("Api Gateway authorization filter executed");
        return ((exchange, chain) -> {
            var exchangeRequest = exchange.getRequest();
            HeaderModel headerModel = HeaderModel
                    .decorator()
                    .decorate(exchangeRequest);
            var exception = new JSecurityException(this.messageProvider.fail("F_0000000002", headerModel.getLang()));
            if (!this.checkHeaderModel(headerModel)) throw exception;
            return chain.filter(exchange);
        });
    }

    private Boolean checkHeaderModel(HeaderModel headerModel) {
        return this.jwtService.validateToken(headerModel);
    }
}
