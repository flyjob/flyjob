package az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple;

import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Getter
@SuperBuilder
public class SimpleAnyExperienceResponseModel extends AnyBaseResponseModel {
    private Integer orderNumber;
    private String jobTitle;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public static SimpleAnyExperienceResponseModel of(ExperienceRoot root){
        return SimpleAnyExperienceResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .orderNumber(root.getOrderNumber())
                .jobTitle(root.getJobTitle())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .build();
    }
}
