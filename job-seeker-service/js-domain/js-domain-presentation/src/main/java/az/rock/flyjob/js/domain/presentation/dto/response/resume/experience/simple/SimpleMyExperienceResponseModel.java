package az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple;

import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Getter
@SuperBuilder
public class SimpleMyExperienceResponseModel extends MyBaseResponseModel {
    private Integer orderNumber;
    private String jobTitle;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public static SimpleMyExperienceResponseModel of(ExperienceRoot root){
        return SimpleMyExperienceResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .accessModifier(root.getAccessModifier())
                .orderNumber(root.getOrderNumber())
                .jobTitle(root.getJobTitle())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .build();
    }
}
