package az.rock.flyjob.js.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Value("${spring.minio.url}")
    private String minioUrl;

    @Value("${spring.minio.bucket}")
    private String miniobucket;

    @Value("${spring.minio.access-key}")
    private String accessKey;

    @Value("${spring.minio.secret-key}")
    private String secretKey;

    @Bean(name = "jsMinioClient")
    public MinioClient authMinioClient() {
        return MinioClient.builder()
                .endpoint(this.minioUrl)
                .credentials(this.accessKey, this.secretKey)
                .build();
    }

    public String getMiniobucket() {
        return miniobucket;
    }
}
