package az.rock.lib.valueObject;

import java.io.InputStream;
import java.util.UUID;

public final class MultipartFileWrapper {

    private String originalFileName;
    private String absolutePath;
    private FileContentType contentType;
    private InputStream content;
    private String charset;
    private Long size;
    private UploadType uploadType;
    private FileType fileType;

    private MultipartFileWrapper(Builder builder) {
        originalFileName = builder.originalFileName;
        absolutePath = builder.absolutePath;
        contentType = builder.contentType;
        content = builder.content;
        charset = builder.charset;
        size = builder.size;
        uploadType = builder.uploadType;
        fileType = builder.fileType;
    }


    public String getOriginalFileName() {
        return originalFileName;
    }

    public String getAbsolutePath() {
        var currentMillis = System.currentTimeMillis();
        return contentType.getValue()
                .concat("/")
                .concat(UUID.randomUUID().toString())
                .concat("_")
                .concat(String.valueOf(currentMillis))
                .concat("_")
                .concat(absolutePath);
    }

    public FileContentType getContentType() {
        return contentType;
    }

    public InputStream getContent() {
        return content;
    }

    public String getCharset() {
        return charset;
    }

    public Long getSize() {
        return size;
    }

    public UploadType getUploadType() {
        return uploadType;
    }

    public FileType getFileType() {
        return fileType;
    }


    public static final class Builder {
        private String originalFileName;
        private String absolutePath;
        private FileContentType contentType;
        private InputStream content;
        private String charset;
        private Long size;
        private UploadType uploadType;
        private FileType fileType;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder originalFileName(String val) {
            originalFileName = val;
            return this;
        }

        public Builder absolutePath(String val) {
            absolutePath = val;
            return this;
        }

        public Builder contentType(FileContentType val) {
            contentType = val;
            return this;
        }

        public Builder content(InputStream val) {
            content = val;
            return this;
        }

        public Builder charset(String val) {
            charset = val;
            return this;
        }

        public Builder size(Long val) {
            size = val;
            return this;
        }

        public Builder uploadType(UploadType val) {
            uploadType = val;
            return this;
        }

        public Builder fileType(FileType val) {
            fileType = val;
            return this;
        }

        public MultipartFileWrapper build() {
            return new MultipartFileWrapper(this);
        }
    }
}
