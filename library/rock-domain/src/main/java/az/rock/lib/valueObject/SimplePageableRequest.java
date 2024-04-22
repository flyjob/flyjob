package az.rock.lib.valueObject;

public class SimplePageableRequest {
    private int page;
    private int size;

    public SimplePageableRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    private SimplePageableRequest(Builder builder) {
        setPage(builder.page);
        setSize(builder.size);
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static final class Builder {
        private int page;
        private int size;

        public Builder() {
        }

        public Builder page(int val) {
            page = val;
            return this;
        }

        public Builder size(int val) {
            size = val;
            return this;
        }

        public SimplePageableRequest build() {
            return new SimplePageableRequest(this);
        }
    }
}
