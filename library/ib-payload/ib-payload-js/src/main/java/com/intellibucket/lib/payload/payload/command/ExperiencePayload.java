package com.intellibucket.lib.payload.payload.command;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.WorkingTimeLineType;
import az.rock.lib.valueObject.WorkingType;
import com.intellibucket.lib.payload.payload.Payload;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ExperiencePayload extends Payload {
    private  UUID id;

    public ExperiencePayload(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }


    public static ExperiencePayload of(UUID Id) {
        return new ExperiencePayload(Id);
    }

}
