package az.rock.flyjob.js.domain.presentation.dto.response.resume.contact;

import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ContactFormatType;
import az.rock.lib.valueObject.ContactLiveType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class MyContactResponseModel extends MyBaseResponseModel {
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private ContactFormatType formatType;
    private ContactLiveType liveType;
    private String data;

    public static MyContactResponseModel of(ContactRoot root) {
        return MyContactResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .accessModifier(root.getAccessModifier())
                .orderNumber(root.getOrderNumber())
                .formatType(root.getFormatType())
                .liveType(root.getLiveType())
                .data(root.getData())
                .build();
    }
}
