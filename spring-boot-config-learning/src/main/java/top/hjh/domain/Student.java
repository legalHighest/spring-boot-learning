package top.hjh.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 14 14 34
 **/

@Component
@Data
public class Student {


    private Integer id;
    @Value("${student.name}")
    private String name;




}
