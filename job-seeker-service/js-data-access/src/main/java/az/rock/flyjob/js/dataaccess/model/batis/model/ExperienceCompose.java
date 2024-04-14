package az.rock.flyjob.js.dataaccess.model.batis.model;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data
public class ExperienceCompose {
    private UUID uuid;

    private Long version;

    private String processStatus;

    private String rowStatus;

    private Date createdDate;

    private Date modificationDate;

    private UUID resumeUuid;

    private String accessModifier;

    private Integer orderNumber;

    private String employer;

    private String link;

    private String jobTitle;

    private UUID cityId;

    private String workingType;

    private String workingTimeType;

    private String description;

    @Temporal(value = TemporalType.DATE)
    private Timestamp startDate;

    @Temporal(value = TemporalType.DATE)
    private Timestamp endDate;

}