package az.rock.flyjob.js.dataaccess.model.batis.model;

import az.rock.lib.valueObject.SimplePageableRequest;

public class Pageable {
    int offset;
    int limit;

    private Pageable(Builder builder) {
        setOffset(builder.offset);
        setLimit(builder.limit);
    }

    public static Pageable of(SimplePageableRequest request){
        if(request.getPage()<=0 || request.getSize()<=0)return null;
        int offset = (request.getPage()-1) * request.getSize();
        return Builder.builder().offset(offset).limit(request.getSize()).build();
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public static final class Builder {
        private int offset;
        private int limit;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder offset(int val) {
            offset = val;
            return this;
        }

        public Builder limit(int val) {
            limit = val;
            return this;
        }

        public Pageable build() {
            return new Pageable(this);
        }
    }
}

