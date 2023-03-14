package top.hjh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import top.hjh.service.MyService;

/**
 * @Author huang
 * @Description 使用Configuration 编写自定义配置类
 * @Date 2023 03 14 15 05
 **/

@Data

@PropertySource("classpath:my.properties")//指定自定义配置文件的位置和名称
@ConfigurationProperties(prefix = "config")//指定配置文件的注入属性的前缀
@Configuration
public class MyConfig {
    //将该方法的返回值，作为一个Bean，添加到Spring容器中，该Bean的id就是方法名

    /**
     *
     * @return MyService实例
     */
    @Bean
    public MyService myService(){
       return  new MyService();
    }
}
