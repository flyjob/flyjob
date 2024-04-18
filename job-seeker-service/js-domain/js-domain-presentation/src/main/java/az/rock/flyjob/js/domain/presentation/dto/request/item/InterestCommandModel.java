package az.rock.flyjob.js.domain.presentation.dto.request.item;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.AbstractCommandModel;

public class InterestCommandModel extends AbstractCommandModel {
    private Boolean isHobby;
    private String name;
    private String description;

    public InterestCommandModel(Boolean isHobby, String name, String description) {
        this.isHobby = isHobby;
        this.name = name;
        this.description = description;
    }

    public Boolean getHobby() {
        return isHobby;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setHobby(Boolean hobby) {
        isHobby = hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
