package az.rock.auth.domain.presentation.handler.concretes.email;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.handler.abstracts.email.AbstractEmailUpdateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractEmailDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractEmailCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractEmailQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.email.EmailUpdatedEvent;
import az.rock.flyjob.auth.exception.email.EmailNotFoundException;
import az.rock.flyjob.auth.model.root.user.EmailRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractEmailDomainService;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.valueObject.SwitchCase;
import org.springframework.stereotype.Component;

@Component
public class EmailUpdateCommandHandler implements AbstractEmailUpdateCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter;
    private final AbstractEmailCommandRepositoryAdapter emailCommandRepositoryAdapter;
    private final AbstractEmailDomainService emailDomainService;
    private final AbstractEmailDomainMapper emailDomainMapper;

    public EmailUpdateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                     AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter,
                                     AbstractEmailCommandRepositoryAdapter emailCommandRepositoryAdapter,
                                     AbstractEmailDomainService emailDomainService,
                                     AbstractEmailDomainMapper emailDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.emailQueryRepositoryAdapter = emailQueryRepositoryAdapter;
        this.emailCommandRepositoryAdapter = emailCommandRepositoryAdapter;
        this.emailDomainService = emailDomainService;
        this.emailDomainMapper = emailDomainMapper;
    }

    @Override
    public EmailUpdatedEvent handleEmailChanged(EmailChangeRequest emailChangeRequest) {
        var currentUserId = this.securityContextHolder.availableUser();
        var emails = this.emailQueryRepositoryAdapter.findAllMyEmails(currentUserId);
        var optionalOldEmail = emails.stream().filter(item->item.getRootID().getAbsoluteID().equals(emailChangeRequest.getEmailUUID())).findFirst();
        if(optionalOldEmail.isPresent()){
            var oldEmail  = optionalOldEmail.get();
            var newEmail = this.emailDomainMapper.mapToEmailRoot(oldEmail,emailChangeRequest);
            this.emailDomainService.validateForChangeEmail(oldEmail,newEmail);
            this.emailCommandRepositoryAdapter.update(newEmail);
            return EmailUpdatedEvent.of(newEmail);
        }else throw new EmailNotFoundException();
    }

    @Override
    public EmailUpdatedEvent handleEmailDeleted(EmailID emailID) {
        var currentUserId = this.securityContextHolder.availableUser();
        var email = this.emailQueryRepositoryAdapter.findMyEmailByID(currentUserId,emailID);
        if(email.isPresent()) {
            this.emailDomainService.validateForDeleteEmail(currentUserId,email.get());
            this.emailCommandRepositoryAdapter.inActive(email.get());
            return EmailUpdatedEvent.of(email.get());
        }else throw new EmailNotFoundException();
    }

    @Override
    public EmailUpdatedEvent handleEmailSetPrimary(EmailID emailID) {
        // FIXME: 27.06.23
        var currentUserId = this.securityContextHolder.availableUser();
        var emails = this.emailQueryRepositoryAdapter.findAllMyEmails(currentUserId);
        var changedEmail = emails.stream()
                .map(EmailRoot::changeUnPrimary)
                .filter(item->item.getRootID().equals(emailID))
                .map(EmailRoot::changePrimary)
                .findFirst();
        if(changedEmail.isPresent()){
            this.emailCommandRepositoryAdapter.updateAll(emails);
            return EmailUpdatedEvent.of(changedEmail.get());
        }else throw new EmailNotFoundException();
    }

    @Override
    public EmailUpdatedEvent handleEmailNotification(SwitchCase switchCase) {
        var currentUserId = this.securityContextHolder.availableUser();
        var email = this.emailQueryRepositoryAdapter.findMyEmailByID(currentUserId,EmailID.of(switchCase.getUuid()));
        if(email.isPresent()) {
            EmailRoot changedEmail = this.emailDomainService.validateAndInitializeEmailNotification(currentUserId,email.get(), switchCase);
            this.emailCommandRepositoryAdapter.update(changedEmail);
            return EmailUpdatedEvent.of(email.get());
        }else throw new EmailNotFoundException();
    }

    @Override
    public EmailUpdatedEvent handleEmailSubscribedPromotions(SwitchCase switchCase) {
        var currentUserId = this.securityContextHolder.availableUser();
        var email = this.emailQueryRepositoryAdapter.findMyEmailByID(currentUserId,EmailID.of(switchCase.getUuid()));
        if(email.isPresent()) {
            EmailRoot changedEmail = this.emailDomainService.validateAndInitializeEmailSubscribedPromotions(currentUserId, email.get(), switchCase);
            this.emailCommandRepositoryAdapter.update(changedEmail);
            return EmailUpdatedEvent.of(email.get());
        }else throw new EmailNotFoundException();
    }
}
