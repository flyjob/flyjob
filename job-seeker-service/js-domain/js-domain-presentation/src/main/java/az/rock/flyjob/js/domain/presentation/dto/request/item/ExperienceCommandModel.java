package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;
import az.rock.lib.valueObject.WorkingTimeLineType;
import az.rock.lib.valueObject.WorkingType;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ExperienceCommandModel extends AbstractCommandModel {
    private String employer;
    private String link;
    private String jobTitle;
    private UUID cityId;
    private WorkingType workingType;
    private WorkingTimeLineType workingTimeLine;
    private String description;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public ExperienceCommandModel(String employer
            , String link
            , String jobTitle
            , UUID cityId
            , WorkingType workingType
            , WorkingTimeLineType workingTimeLine
            , String description
            , ZonedDateTime startDate
            , ZonedDateTime endDate) {
        this.employer = employer;
        this.link = link;
        this.jobTitle = jobTitle;
        this.cityId = cityId;
        this.workingType = workingType;
        this.workingTimeLine = workingTimeLine;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getEmployer() {
        return employer;
    }

    public String getLink() {
        return link;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public UUID getCityId() {
        return cityId;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public WorkingTimeLineType getWorkingTimeLine() {
        return workingTimeLine;
    }

    public String getDescription() {
        return description;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }
}
