package az.rock.flyjob.js.dataaccess.model.batis.model;

import lombok.Data;

import java.util.Date;

@Data
public class ExperienceCompose {
    private Object uuid;

    private Long version;

    private String processStatus;

    private String rowStatus;

    private Date createdDate;

    private Date modificationDate;

    private Object resumeUuid;

    private String accessModifier;

    private Integer orderNumber;

    private String employer;

    private String link;

    private String jobTitle;

    private Object cityId;

    private String workingType;

    private String workingTimeType;

    private String description;

    private Date startDate;

    private Date endDate;

}