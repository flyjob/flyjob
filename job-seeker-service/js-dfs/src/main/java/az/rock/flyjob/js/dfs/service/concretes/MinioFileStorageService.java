package az.rock.flyjob.js.dfs.service.concretes;


import az.rock.flyjob.js.dfs.mapper.FileMetaDataMapper;
import az.rock.flyjob.js.dfs.service.abstracts.AbstractMinioService;
import az.rock.flyjob.js.domain.presentation.ports.dfs.AbstractFileStorageAdapter;
import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Service;


@Service
public class MinioFileStorageService implements AbstractFileStorageAdapter {
    private final AbstractMinioService minioService;

    private final FileMetaDataMapper fileMetaDataMapper;

    public MinioFileStorageService(AbstractMinioService minioService,
                                   FileMetaDataMapper fileMetaDataMapper) {
        this.minioService = minioService;
        this.fileMetaDataMapper = fileMetaDataMapper;
    }

    @Override
    public FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper) {
        try {
            var response = this.minioService.upload(multipartFileWrapper);
            return this.fileMetaDataMapper.map(response);
        } catch (MinioException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] get(String path) {
        return this.minioService.get(path);
    }

}
