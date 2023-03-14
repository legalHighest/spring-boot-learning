package top.hjh.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 14 15 17
 **/
@SpringBootTest
class MyConfigTest {

    @Autowired
    private MyConfig config;

    @Test
    public  void test(){
      config.myService().sayHell();
    }
}