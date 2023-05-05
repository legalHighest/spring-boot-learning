package top.hjh.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 16 18 51
 **/
@SpringBootTest
class OssConfigTest {
 @Autowired
    private OssConfig ossConfig=new OssConfig();

 @Test
    public  void test(){
     System.out.println(ossConfig);
 }
}