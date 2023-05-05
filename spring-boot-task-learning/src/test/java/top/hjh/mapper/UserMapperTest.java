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
 * @Date 2023 04 04 18 17
 **/
@SpringBootTest
class UserMapperTest {
@Resource
    private  UserMapper userMapper;
@Test
    public void test(){
    List<User> users = userMapper.selectList(null);
    System.out.println(users);
}
}