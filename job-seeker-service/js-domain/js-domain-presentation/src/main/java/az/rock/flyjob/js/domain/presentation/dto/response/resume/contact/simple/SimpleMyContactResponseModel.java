package az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ContactFormatType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleMyContactResponseModel extends MyBaseResponseModel {
    private AccessModifier accessModifier;
    private ContactFormatType formatType;
    private String data;

    public static SimpleMyContactResponseModel of(ContactRoot root) {
        return SimpleMyContactResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .accessModifier(root.getAccessModifier())
                .formatType(root.getFormatType())
                .data(root.getData())
                .build();
    }
}
