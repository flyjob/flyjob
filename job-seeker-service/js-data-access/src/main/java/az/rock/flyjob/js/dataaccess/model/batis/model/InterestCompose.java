package az.rock.flyjob.js.dataaccess.model.batis.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class InterestCompose {
    private UUID uuid;

    private Long version;

    private String processStatus;

    private String rowStatus;

    private Date createdDate;

    private Date modificationDate;

    private UUID resumeUuid;

    private String accessModifier;

    private Integer orderNumber;

    private Boolean isHobby;

    private String name;

    private String description;


}