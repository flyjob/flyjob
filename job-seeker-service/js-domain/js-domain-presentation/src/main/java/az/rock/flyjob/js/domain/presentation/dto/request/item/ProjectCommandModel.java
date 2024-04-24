package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class ProjectCommandModel extends AbstractCommandModel {
    private String title;
    private String subtitle;
    private String link;
    private LocalDate startDate;
    private LocalDate endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
}
