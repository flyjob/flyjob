package az.rock.flyjob.js.dataaccess.model.batis.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data
public class CourseCompose {
    private UUID uuid;

    private Long version;

    private String processStatus;

    private String rowStatus;

    private Timestamp createdDate;

    private Timestamp modificationDate;

    private UUID resumeUuid;

    private String accessModifier;

    private Integer orderNumber;

    private String courseTitle;

    private String institution;

    private Boolean isOnline;

    private String city;

    private String country;

    private Date startDate;

    private Date endDate;

    private String isContinue;

    private String certificateFilePath;

    private String verificationAddress;

}