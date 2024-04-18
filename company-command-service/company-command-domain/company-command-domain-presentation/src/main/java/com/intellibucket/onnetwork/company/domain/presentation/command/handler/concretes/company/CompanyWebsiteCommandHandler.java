package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.event.create.website.CompanyWebsiteCreatedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteDeletedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteUpdatedEvent;
import com.intellibucket.lib.payload.website.CompanyWebsiteCreatedPayload;
import com.intellibucket.lib.payload.website.CompanyWebsiteDeletedPayload;
import com.intellibucket.lib.payload.website.CompanyWebsiteUpdatedPayload;
import com.intellibucket.onnetwork.company.domain.core.command.exception.MultipleActiveRowsException;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyWebsiteDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.exception.DomainException;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCompanyWebsiteCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyWebsiteDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyWebsiteCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyWebsiteQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CompanyWebsiteCommandHandler implements AbstractCompanyWebsiteCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractCompanyWebsiteQueryRepositoryAdapter companyWebsiteQueryRepositoryAdapter;
    private final AbstractCompanyWebsiteCommandRepositoryAdapter companyWebsiteCommandRepositoryAdapter;
    private final AbstractCompanyWebsiteDomainMapper companyWebsiteDomainMapper;

    private final AbstractCompanyWebsiteDomainService companyWebsiteDomainService;


    public CompanyWebsiteCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                        AbstractCompanyWebsiteQueryRepositoryAdapter
                                                companyWebsiteQueryRepositoryAdapter,
                                        AbstractCompanyWebsiteCommandRepositoryAdapter
                                                companyWebsiteCommandRepositoryAdapter,
                                        AbstractCompanyWebsiteDomainMapper companyWebsiteDomainMapper,
                                        AbstractCompanyWebsiteDomainService companyWebsiteDomainService) {
        this.securityContextHolder = securityContextHolder;
        this.companyWebsiteQueryRepositoryAdapter = companyWebsiteQueryRepositoryAdapter;
        this.companyWebsiteCommandRepositoryAdapter = companyWebsiteCommandRepositoryAdapter;
        this.companyWebsiteDomainMapper = companyWebsiteDomainMapper;
        this.companyWebsiteDomainService = companyWebsiteDomainService;
    }

    @Override
    public CompanyWebsiteCreatedEvent createWebsiteByCompany(CompanyWebsiteCommand command) {
        var currentCompany = this.securityContextHolder.currentCompany();
        var websiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        websiteRoot.ifPresentOrElse(
                root -> updateWebsiteRootIfExists(root,command),
                () -> createNewCompanyWebsiteRoot(command, currentCompany)
        );
        return CompanyWebsiteCreatedEvent.of(new CompanyWebsiteCreatedPayload());
    }

    @Override
    public CompanyWebsiteUpdatedEvent changeWebsiteByCompany(CompanyWebsiteCommand command) {
        var currentCompany = this.securityContextHolder.currentCompany();
        var optionalWebsiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        optionalWebsiteRoot.ifPresentOrElse(oldWebsiteRoot -> {
            this.companyWebsiteDomainService.validateIsSameWebsite(oldWebsiteRoot, command.getWebsite());
            var newWebsiteRoot = this.companyWebsiteDomainMapper.mapToWebsiteRoot(oldWebsiteRoot, command);
            this.companyWebsiteCommandRepositoryAdapter.update(newWebsiteRoot);
        }, () -> {throw new NoActiveRowException();
        });
        return CompanyWebsiteUpdatedEvent.of(new CompanyWebsiteUpdatedPayload());
    }

    @Override
    public CompanyWebsiteDeletedEvent deleteWebsiteCompany() {
        var currentCompany = this.securityContextHolder.currentCompany();
        var optionalWebsiteRoot = this.companyWebsiteQueryRepositoryAdapter.findCompanyWebsiteByCompanyId(currentCompany);
        optionalWebsiteRoot.ifPresentOrElse(
                websiteRoot -> this.companyWebsiteCommandRepositoryAdapter.delete(websiteRoot),
                () -> {
                    throw new NoActiveRowException();
                }
        );
        return CompanyWebsiteDeletedEvent.of(new CompanyWebsiteDeletedPayload());

    }

    private void updateWebsiteRootIfExists(WebsiteRoot websiteRoot,CompanyWebsiteCommand command) {
        if (websiteRoot.isDeleted()) {
            var newWebsiteRoot = this.companyWebsiteDomainMapper.mapToWebsiteRoot(websiteRoot, command);
            this.companyWebsiteCommandRepositoryAdapter.update(newWebsiteRoot);
        } else {
            throw new MultipleActiveRowsException("F0000000009");
        }
    }

    private void createNewCompanyWebsiteRoot(CompanyWebsiteCommand command, CompanyID companyID) {
        var newEmailRoot = this.companyWebsiteDomainMapper.toNewCompanyWebsiteRoot(command,companyID);
        var savedRoot = this.companyWebsiteCommandRepositoryAdapter.create(newEmailRoot);
        if (savedRoot.isEmpty()) {
            throw new DomainException("F0000000001");
        }
    }
}
