package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;

import java.util.Optional;
import java.util.UUID;


@DomainOutputPort
public interface AbstractContactQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<ContactRoot, ContactID, ResumeID> {
    Boolean isExistContact(ContactRoot contactRoot);
    Optional<ContactRoot> findContact(ResumeID resumeID, UUID uuid);
}
