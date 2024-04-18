package az.rock.flyjob.js.domain.presentation.dto.response.resume.contact;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import az.rock.lib.valueObject.ContactFormatType;
import az.rock.lib.valueObject.ContactLiveType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class AnyContactResponseModel extends AnyBaseResponseModel {
    private Integer orderNumber;
    private ContactFormatType formatType;
    private ContactLiveType liveType;
    private String data;

    public static AnyContactResponseModel of(ContactRoot root) {
        return AnyContactResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .orderNumber(root.getOrderNumber())
                .formatType(root.getFormatType())
                .liveType(root.getLiveType())
                .data(root.getData())
                .build();
    }
}
