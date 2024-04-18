package az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.lib.valueObject.js.EducationDegree;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder
public class SimpleAnyEducationResponseModel {
    private EducationDegree degree;
    private String establishmentName;
    private LocalDate startDate;
    private LocalDate endDate;

    public static SimpleAnyEducationResponseModel of(EducationRoot root) {
        return SimpleAnyEducationResponseModel.builder()
                .degree(root.getDegree())
                .establishmentName(root.getEstablishmentName())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .build();
    }
}
