package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.concretes;

import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.domain.id.company.WebsiteID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyWebsiteDomainMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompanyWebsiteDomainMapper implements AbstractCompanyWebsiteDomainMapper {
    @Override
    public WebsiteRoot toNewCompanyWebsiteRoot(CompanyWebsiteCommand companyWebsiteChangedCommand,
                                               CompanyID companyID) {
       return WebsiteRoot.Builder.builder()
                .uuid(WebsiteID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .companyID(companyID)
                .isVerified(false)
                .website(companyWebsiteChangedCommand.getWebsite())
                .build();
    }

    @Override
    public WebsiteRoot mapToWebsiteRoot(WebsiteRoot oldWebsiteRoot,
                                        CompanyWebsiteCommand companyWebsiteChangedCommand) {
        return WebsiteRoot.Builder.builder()
                .uuid(oldWebsiteRoot.getRootID())
                .version(oldWebsiteRoot.getVersion())
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .companyID(oldWebsiteRoot.getCompanyID())
                .isVerified(false)
                .website(companyWebsiteChangedCommand.getWebsite())
                .verificationRequestDate(null)
                .verificationResponseDate(null)
                .build();
    }
}
