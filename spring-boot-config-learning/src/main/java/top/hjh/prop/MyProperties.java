package top.hjh.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 14 14 56
 **/

@Data
@Configuration //标志文本为配置类
@PropertySource("classpath:my.properties")//指定自定义配置文件的位置和名称
@ConfigurationProperties(prefix = "my")//指定配置文件的注入属性的前缀
public class MyProperties {

    private  String url;
    private  String username;

    private String password;
}
