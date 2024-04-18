package az.rock.flyjob.js.dfs.mapper;


import az.rock.lib.valueObject.FileMetaData;
import io.minio.ObjectWriteResponse;
import org.springframework.stereotype.Component;

@Component
public class FileMetaDataMapper {
    public FileMetaData map(ObjectWriteResponse objectWriteResponse) {
        return FileMetaData.Builder.builder()
                .etag(objectWriteResponse.etag())
                .versionId(objectWriteResponse.versionId())
                .object(objectWriteResponse.object())
                .region(objectWriteResponse.region())
                .bucket(objectWriteResponse.bucket())
                .fileSize(objectWriteResponse.headers().byteCount())
                .build();
    }
}
