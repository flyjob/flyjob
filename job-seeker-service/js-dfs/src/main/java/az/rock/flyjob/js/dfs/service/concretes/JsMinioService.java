package az.rock.flyjob.js.dfs.service.concretes;

import az.rock.flyjob.js.dfs.service.abstracts.AbstractMinioService;
import az.rock.lib.valueObject.MultipartFileWrapper;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class JsMinioService implements AbstractMinioService {

    private static final String BUCKET_NAME = "js-bucket";
//    private final MinioClient minioClient;

//    public JsMinioService(@Qualifier(value = "jsMinioClient") MinioClient minioClient) {
//        this.minioClient = minioClient;
//    }

    @Override
    public ObjectWriteResponse upload(MultipartFileWrapper multipartFileWrapper) {
//        try {
//            var args = PutObjectArgs
//                    .builder()
//                    .bucket(BUCKET_NAME)
//                    .object(multipartFileWrapper.getAbsolutePath())
//                    .stream(multipartFileWrapper.getContent(), -1, 10485760)
//                    .build();
//            return this.minioClient.putObject(args);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    @Override
    public byte[] get(String path){
//        try {
//            var response = this.minioClient.getObject(
//                    GetObjectArgs
//                            .builder()
//                            .bucket(BUCKET_NAME)
//                            .object(path)
//                            .build()
//            );
//            return response.readAllBytes();
//        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
//                 InvalidResponseException | NoSuchAlgorithmException | IOException | ServerException |
//                 XmlParserException e) {
//            throw new RuntimeException(e);
//        }
        return new byte[0];
    }
}
