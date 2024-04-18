package az.rock.flyjob.js.dfs.service.abstracts;

import az.rock.lib.valueObject.MultipartFileWrapper;
import io.minio.ObjectWriteResponse;
import io.minio.errors.MinioException;

import java.io.InputStream;
import java.nio.file.Path;

public interface AbstractMinioService {
    ObjectWriteResponse upload(MultipartFileWrapper multipartFileWrapper) throws MinioException;

    byte[] get(String path);
}
