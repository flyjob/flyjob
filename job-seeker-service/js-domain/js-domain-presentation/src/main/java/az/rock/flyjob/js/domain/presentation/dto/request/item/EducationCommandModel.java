package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;

import java.time.ZonedDateTime;
import java.util.UUID;

public class EducationCommandModel extends AbstractCommandModel {
    private final EducationDegree degree;
    private final EducationState state;
    private final String link;
    private final UUID establishmentUUID;
    private final String establishmentName;
    private final UUID cityId;
    private final ZonedDateTime startDate;
    private final ZonedDateTime endDate;
    private final String description;

    public EducationCommandModel(EducationDegree degree, EducationState state, String link, UUID establishmentUUID, String establishmentName, UUID cityId, ZonedDateTime startDate, ZonedDateTime endDate, String description) {
        this.degree = degree;
        this.state = state;
        this.link = link;
        this.establishmentUUID = establishmentUUID;
        this.establishmentName = establishmentName;
        this.cityId = cityId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public EducationDegree getDegree() {
        return degree;
    }

    public EducationState getState() {
        return state;
    }

    public String getLink() {
        return link;
    }

    public UUID getEstablishmentUUID() {
        return establishmentUUID;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public UUID getCityId() {
        return cityId;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
}
