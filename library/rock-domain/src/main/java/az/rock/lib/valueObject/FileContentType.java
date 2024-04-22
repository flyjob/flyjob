package az.rock.lib.valueObject;

import java.util.stream.Stream;

public enum FileContentType {
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PJPEG("image/pjpeg"),
    IMAGE_JPG("image/jpg"),
    IMAGE_PNG("image/png"),
    IMAGE_GIF("image/gif"),
    IMAGE_BMP("image/bmp"),
    IMAGE_SVG("image/svg+xml"),
    IMAGE_WEBP("image/webp"),
    IMAGE_TIFF("image/tiff"),
    IMAGE_X_ICON("image/x-icon"),
    IMAGE_X_MS_BMP("image/x-ms-bmp"),
    IMAGE_X_PORTABLE_ANYMAP("image/x-portable-anymap");

    private final String value;

    FileContentType(String value) {
        this.value = value;
    }

    public static FileContentType fromValue(String value) {
        return Stream.of(FileContentType.values()).filter(v -> v.value.equals(value)).findFirst().orElseThrow();
    }

    public String getValue() {
        return value;
    }
}
