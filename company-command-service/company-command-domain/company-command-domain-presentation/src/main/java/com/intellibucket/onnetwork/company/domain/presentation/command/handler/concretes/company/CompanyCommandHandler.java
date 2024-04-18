package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import az.rock.lib.jexception.JDomainException;
import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.event.create.CompanyFilledEvent;
import com.intellibucket.lib.event.create.companyprofile.CompanyProfileCreatedEvent;
import com.intellibucket.lib.payload.CompanyFilledPayload;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileCreatedPayload;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractsCompanyDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CompanyCommandHandler implements AbstractCreateCompanyCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractsCompanyDomainMapper companyDomainMapper;

    private final AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter;

    private final AbstractsCompanyDomainService companyDomainService;

    private final AbstractCompanyQueryRepositoryAdapter companyQueryRepositoryAdapter;


    public CompanyCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                 AbstractsCompanyDomainMapper companyDomainMapper,
                                 AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter,
                                 AbstractsCompanyDomainService companyDomainService,
                                 AbstractCompanyQueryRepositoryAdapter companyQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.companyDomainMapper = companyDomainMapper;
        this.companyCommandRepositoryAdapter = companyCommandRepositoryAdapter;
        this.companyDomainService = companyDomainService;
        this.companyQueryRepositoryAdapter = companyQueryRepositoryAdapter;
    }

    @Override
    public CompanyProfileCreatedEvent createCompany(CompanyRegistrationPayload payload) throws JDomainException {
        var newCompanyRoot = this.companyDomainMapper.toNewCompanyRoot(payload);
        var savedRoot = this.companyCommandRepositoryAdapter.create(newCompanyRoot);
        if (savedRoot.isEmpty()) throw new JRuntimeException("F0000000001");
        return new CompanyProfileCreatedEvent(new CompanyProfileCreatedPayload(savedRoot.get().getRootID().getAbsoluteID()));
    }

    @Override
    public CompanyFilledEvent filled(CompanyFilledCommand companyFilledCommand)  {
        var currentCompany = this.securityContextHolder.currentCompany();
        var optionalCompanyById = this.companyQueryRepositoryAdapter.getCompanyRoot(currentCompany);

        return optionalCompanyById.map(companyRoot -> {
            companyRoot = companyDomainService.fillNameAndDescription(companyRoot,
                    companyFilledCommand.getName(),
                    companyFilledCommand.getDescription());
            this.companyCommandRepositoryAdapter.update(companyRoot);
            return CompanyFilledEvent.of(new CompanyFilledPayload());
        }).orElseThrow(NoActiveRowException::new);

    }
}
