package az.rock.flyjob.js.domain.core.service.concretes;

import az.rock.flyjob.js.domain.core.exception.ContactAlreadyExistException;
import az.rock.flyjob.js.domain.core.exception.InvalidContactException;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractContactDomainService;

import java.util.List;

public class ContactDomainService implements AbstractContactDomainService {

    @Override
    public ContactRoot validateContactDuplication(List<ContactRoot> savedContact, ContactRoot newContact) {
        if (savedContact.contains(newContact)) throw new ContactAlreadyExistException();
        if (!newContact.isValid()) throw new InvalidContactException();
        return newContact;
    }
}
