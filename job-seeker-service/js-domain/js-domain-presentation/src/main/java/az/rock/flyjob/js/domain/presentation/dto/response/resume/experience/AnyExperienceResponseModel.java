package az.rock.flyjob.js.domain.presentation.dto.response.resume.experience;

import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import az.rock.lib.valueObject.WorkingTimeLineType;
import az.rock.lib.valueObject.WorkingType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
@SuperBuilder
public class AnyExperienceResponseModel extends AnyBaseResponseModel {
    private Integer orderNumber;
    private String employer;
    private String link;
    private String jobTitle;
    private UUID cityId;
    private WorkingType workingType;
    private WorkingTimeLineType workingTimeLine;
    private String description;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public static AnyExperienceResponseModel of(ExperienceRoot root){
        return AnyExperienceResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .orderNumber(root.getOrderNumber())
                .employer(root.getEmployer())
                .link(root.getLink())
                .jobTitle(root.getJobTitle())
                .cityId(root.getCityId())
                .workingType(root.getWorkingType())
                .workingTimeLine(root.getWorkingTimeType())
                .description(root.getDescription())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .build();
    }

}
