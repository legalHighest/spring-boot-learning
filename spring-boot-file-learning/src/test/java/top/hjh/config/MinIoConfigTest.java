package top.hjh.config;

import io.minio.ObjectWriteResponse;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 10 15 36
 **/
@SpringBootTest
class MinIoConfigTest {
@Resource
private MinIoConfig minIoConfig;
    @Test
    void makeBucket() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minIoConfig.makeBucket("hjh");

    }

    @Test
    void uploadObject() throws Exception {
        ObjectWriteResponse response=minIoConfig.uploadObject("hjh","/img/1.png","D:\\learning\\after-end\\upload\\20230410\\1.PNG");
    }

    @Test
    void putObject() {
    }

    @Test
    void removeObject() throws Exception {
        minIoConfig.removeObject("hjh","img/1.png");
    }
}