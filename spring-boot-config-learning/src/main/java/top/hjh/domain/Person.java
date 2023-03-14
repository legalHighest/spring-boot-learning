package top.hjh.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author huang
 * @Description Person
 * @Date 2023 03 14 13 58
 **/
//这个注解会生成person实例放进spring容器中
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private Integer id;
    private String name;

    private List<String> hobby;

    private String[] family;

    private Map<String, Object> map;
    private Pet pet;
}
