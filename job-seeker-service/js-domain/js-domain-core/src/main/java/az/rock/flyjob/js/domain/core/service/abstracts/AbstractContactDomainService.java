package az.rock.flyjob.js.domain.core.service.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;

import java.util.List;

public interface AbstractContactDomainService {
    ContactRoot validateContactDuplication(List<ContactRoot> savedContact, ContactRoot newContact);

}
