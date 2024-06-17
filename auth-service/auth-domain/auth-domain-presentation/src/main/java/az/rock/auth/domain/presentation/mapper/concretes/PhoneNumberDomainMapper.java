package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPhoneNumberDomainMapper;
import az.rock.flyjob.auth.model.root.user.PhoneNumberRoot;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.UUID;

@Component
public class PhoneNumberDomainMapper implements AbstractPhoneNumberDomainMapper {

    @Override
    public PhoneNumberRoot toNewRoot(UserID userID, PhoneNumberCommandRequest request) {
        return PhoneNumberRoot.Builder
                .builder()
                .uuid(PhoneNumberID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .countryCode(request.getCountryCode())
                .phoneNumber(request.getPhoneNumber())
                .isPrimary(Boolean.FALSE)
                .isEnableSmsNotification(Boolean.FALSE)
                .isEnableWhatsappNotification(Boolean.FALSE)
                .isVerified(Boolean.FALSE)
                .verificationCodeSendCount(new BigInteger("0"))
                .user(userID)
                .type(request.getType())
                .build();
    }
}
