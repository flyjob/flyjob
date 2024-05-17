package az.rock.flyjob.js.domain.presentation.dto.criteria;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("all")
public class EducationCriteria {
    private UUID educationId;
    private UUID resumeID;
    private List<AccessModifier> accessModifiers;

    private EducationCriteria(Builder builder) {
        educationId = builder.educationId;
        resumeID = builder.resumeID;
        accessModifiers = builder.accessModifiers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UUID getEducationId() {
        return educationId;
    }

    public UUID getResumeID() {
        return resumeID;
    }

    public List<AccessModifier> getAccessModifiers() {
        return accessModifiers;
    }

    public static final class Builder {
        private UUID educationId;
        private UUID resumeID;
        private List<AccessModifier> accessModifiers;

        private Builder() {
        }

        public Builder educationId(UUID val) {
            educationId = val;
            return this;
        }

        public Builder resumeID(UUID val) {
            resumeID = val;
            return this;
        }

        public Builder accessModifiers(List<AccessModifier> val) {
            accessModifiers = val;
            return this;
        }

        public EducationCriteria build() {
            return new EducationCriteria(this);
        }
    }
}
