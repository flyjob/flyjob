package az.rock.flyjob.js.dataaccess.model.batis.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class EducationCompose {
    private UUID uuid;

    private Long version;

    private String processStatus;

    private String rowStatus;

    private Date createdDate;

    private Date modificationDate;

    private UUID resumeUuid;

    private String accessModifier;

    private Integer orderNumber;

    private String degree;

    private String state;

    private String link;

    private Object establishmentUuid;

    private String establishmentName;

    private Object cityId;

    private Date startDate;

    private Date endDate;

    private String description;

}