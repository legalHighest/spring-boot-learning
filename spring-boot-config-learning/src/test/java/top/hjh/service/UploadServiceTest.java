package top.hjh.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 16 19 09
 **/
@SpringBootTest
class UploadServiceTest {

    @Autowired
    UploadService uploadService;


    @Test
    public  void test(){
   uploadService.toString();
    }
}