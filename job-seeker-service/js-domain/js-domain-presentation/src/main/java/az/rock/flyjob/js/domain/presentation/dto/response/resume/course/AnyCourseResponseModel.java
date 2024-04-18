package az.rock.flyjob.js.domain.presentation.dto.response.resume.course;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.AnyBaseResponseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@SuperBuilder
public class AnyCourseResponseModel extends AnyBaseResponseModel {
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

    public static AnyCourseResponseModel of(CourseRoot root) {
        return AnyCourseResponseModel.builder()
                .id(root.getRootID().getAbsoluteID())
                .lastModifiedDate(root.getModificationDate().toLocalDateTime())
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
