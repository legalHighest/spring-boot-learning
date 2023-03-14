package top.hjh.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.hjh.prop.MyProperties;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 14 15 03
 **/
@SpringBootTest
class MyPropertiesTest {
@Autowired
    private MyProperties properties;

@Test
    void test(){
    System.out.println(properties);
}
}