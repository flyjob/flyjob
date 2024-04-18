package az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import az.rock.lib.valueObject.ContactFormatType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleAnyContactResponseModel extends AnyBaseResponseModel {
    private ContactFormatType formatType;
    private String data;

    public static SimpleAnyContactResponseModel of(ContactRoot root) {
        return SimpleAnyContactResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .formatType(root.getFormatType())
                .data(root.getData())
                .build();
    }
}
