package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.core.root.main.InformationRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.lib.domain.id.js.ResumeID;
import org.springframework.stereotype.Component;


public interface AbstractContactCommandDomainMapper  {
    ContactRoot toNewRoot(ContactCommandModel contactCommandModel, ResumeID resumeID);
    ContactRoot isExistRoot(ContactCommandModel contactCommandModel,ContactRoot contactRoot);

}
