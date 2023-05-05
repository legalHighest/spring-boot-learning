package top.hjh.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.hjh.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 19 20
 **/
@SpringBootTest
class UserMapperTest {
@Resource
private  UserMapper userMapper;
    @Test
    void get() {
        User user=userMapper.get(1);
        System.out.println(user);
    }

    @Test
    void findAll() {
        List<User> users=userMapper.findAll();
        System.out.println(users);
    }

    @Test
    void findAllByNameLike() {
        List<User> users=userMapper.findAllByNameLike("张");
        System.out.println(users);
    }
}