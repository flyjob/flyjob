package az.rock.flyjob.js.domain.presentation.dto.response.resume.project;

import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import az.rock.lib.valueObject.AccessModifier;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder
public class MyProjectResponseModel extends MyBaseResponseModel {
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String link;

    public MyProjectResponseModel of(ProjectRoot root) {
        return MyProjectResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .accessModifier(root.getAccessModifier())
                .link(root.getLink())
                .orderNumber(root.getOrderNumber())
                .startDate(root.getStartDate())
                .description(root.getDescription())
                .build();
    }
}
