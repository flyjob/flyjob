package az.rock.flyjob.js.domain.presentation.dto.criteria;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.List;
import java.util.UUID;

public class InterestCriteria {
    private UUID id;
    private ResumeID resume;

    private boolean isHobby;
    private List<AccessModifier> accessModifier;


    private InterestCriteria(Builder builder) {
        id = builder.id;
        resume = builder.resume;
        isHobby = builder.isHobby;
        accessModifier = builder.accessModifier;
    }

    public UUID getId() {
        return id;
    }

    public ResumeID getResume() {
        return resume;
    }

    public List<AccessModifier> getAccessModifier() {
        return accessModifier;
    }


    public static final class Builder {
        private UUID id;
        private ResumeID resume;
        private boolean isHobby;
        private List<AccessModifier> accessModifier;

        public Builder() {
        }
        public static Builder builder(){
            return new Builder();
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder isHobby(boolean val) {
            isHobby = val;
            return this;
        }

        public Builder accessModifier(List<AccessModifier> val) {
            accessModifier = val;
            return this;
        }

        public InterestCriteria build() {
            return new InterestCriteria(this);
        }
    }
}
