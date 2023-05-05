package top.hjh.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.hjh.domain.User;
import top.hjh.mapper.UserMapper;

import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 19 20
 **/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public User get(Integer id){
        return  userMapper.get(id);
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public List<User> findAllByNameLike(String name){
        return userMapper.findAllByNameLike(name);
    }
}
