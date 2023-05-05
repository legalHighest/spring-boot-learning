package top.hjh.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.hjh.domain.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 20 02
 **/
@SpringBootTest
@Slf4j
class AnnotationUserServiceTest {
@Resource
private AnnotationUserService annotationUserService;
    @Test
    void get() {
        User user1 = annotationUserService.get(1);
        User user2 = annotationUserService.get(1);
log.info(String.valueOf(user1==user2));
    }

    @Test
    public void testUpdate() {
        User user = annotationUserService.get(1);
        user.setName("mybatis test");
        annotationUserService.update(user);
        User user1=annotationUserService.get(1);
        log.info(String.valueOf(user==user1));
    }
}