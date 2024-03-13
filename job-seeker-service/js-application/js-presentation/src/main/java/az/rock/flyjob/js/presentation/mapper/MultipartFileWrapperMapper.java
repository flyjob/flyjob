package az.rock.flyjob.js.presentation.mapper;

import az.rock.lib.valueObject.ContentType;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class MultipartFileWrapperMapper {
    public MultipartFileWrapper map(MultipartFile multipartFile) throws IOException {
        return MultipartFileWrapper.Builder
                .builder()
                .originalFileName(multipartFile.getName())
                .absolutePath(multipartFile.getOriginalFilename())
                .contentType(ContentType.fromValue(multipartFile.getContentType()))
                .content(multipartFile.getResource().getInputStream())
                .size(multipartFile.getSize())
                .build();
    }
}
