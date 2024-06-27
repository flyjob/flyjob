package az.rock.flyjob.js.domain.presentation.dto.criteria;

import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.List;

public class ExperienceCriteria {
    private ExperienceID id;
    private ResumeID resumeID;
    private List<AccessModifier> accessModifiers;

    public ExperienceCriteria() {
    }

    private ExperienceCriteria(Builder builder) {
        setId(builder.id);
        setResumeID(builder.resumeID);
        setAccessModifiers(builder.accessModifiers);
    }

    public ExperienceID getId() {
        return id;
    }

    public void setId(ExperienceID id) {
        this.id = id;
    }

    public ResumeID getResumeID() {
        return resumeID;
    }

    public void setResumeID(ResumeID resumeID) {
        this.resumeID = resumeID;
    }

    public List<AccessModifier> getAccessModifiers() {
        return accessModifiers;
    }

    public void setAccessModifiers(List<AccessModifier> accessModifiers) {
        this.accessModifiers = accessModifiers;
    }

    public static final class Builder {
        private ExperienceID id;
        private ResumeID resumeID;
        private List<AccessModifier> accessModifiers;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ExperienceID val) {
            id = val;
            return this;
        }

        public Builder resumeID(ResumeID val) {
            resumeID = val;
            return this;
        }

        public Builder accessModifiers(List<AccessModifier> val) {
            accessModifiers = val;
            return this;
        }

        public ExperienceCriteria build() {
            return new ExperienceCriteria(this);
        }
    }
}
