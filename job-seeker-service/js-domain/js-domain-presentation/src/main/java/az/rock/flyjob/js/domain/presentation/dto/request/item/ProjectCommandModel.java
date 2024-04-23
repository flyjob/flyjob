package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

import java.time.ZonedDateTime;

public class ProjectCommandModel extends AbstractCommandModel {
    private String title;
    private String subtitle;
    private String link;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getLink() {
        return link;
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
