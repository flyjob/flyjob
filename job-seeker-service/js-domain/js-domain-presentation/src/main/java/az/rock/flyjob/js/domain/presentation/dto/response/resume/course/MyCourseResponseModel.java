package az.rock.flyjob.js.domain.presentation.dto.response.resume.course;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.MyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Getter
@SuperBuilder
public class MyCourseResponseModel extends MyBaseResponseModel {
    private Integer orderNumber;
    private String courseTitle;
    private String institution;
    private Boolean isOnline;
    private String city;
    private String country;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Boolean isVerified;
    private String certificateUrl;

    public static MyCourseResponseModel of(CourseRoot root) {
        return MyCourseResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
                .orderNumber(root.getOrderNumber())
                .courseTitle(root.getCourseTitle())
                .institution(root.getInstitution())
                .isOnline(root.getOnline())
                .city(root.getCity())
                .country(root.getCountry())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .description(root.getDescription())
                .isVerified(root.isVerified())
                .certificateUrl(root.getVerificationAddress())
                .build();
    }
}