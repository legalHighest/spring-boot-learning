package top.hjh.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @Author huang
 * @Description
 * @Date 2023 03 16 17 38
 **/
@Configuration
@PropertySource("classpath:aliyun-oss.properties")
@ConfigurationProperties(prefix = "aliyun-oss")
@Data

public class OssConfig {
    private String endpoint;
    private String bucket;
    private String dir;
    private String host;
    private String ak;
    private String secret;
}
