package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.ContactFormatType;
import az.rock.lib.valueObject.ContactLiveType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactCommandModel extends AbstractCommandModel {

    private ContactFormatType formatType;
    private ContactLiveType liveType;
    private String data;
    private Integer orderNumber;
}
