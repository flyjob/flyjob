package com.intellibucket.lib.payload.payload.command;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ProjectPayload {
    private UUID id;
    private UUID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private String title;
    private String subtitle;
    private String link;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;

}
