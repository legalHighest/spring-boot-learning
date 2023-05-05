package top.hjh.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.hjh.domain.User;
import top.hjh.mapper.UserMapper;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 19 57
 **/
@Slf4j
@Service
public class AnnotationUserService {
    @Resource
    private UserMapper userMapper;

    @Cacheable("user.get")
    public User get(Integer id){
        return userMapper.get(id);
    }

//    @Cacheable(value = "user.get",key = "#root.methodName")
//    public User get(Integer id){
//        return  userMapper.get(id);
//    }

//    @Cacheable(value = "user.get",key = "#root.targetClass.simpleName")
//    public User get(Integer id){
//        return  userMapper.get(id);
//    }
//@Cacheable(value = "user.get",key = "#root.args[0]")
//public User get(Integer id){
//    return  userMapper.get(id);
//}

//    @Cacheable(value = {"user.get", "user.find"}, key = "#root.caches[1]")
//    public User get(Integer id) {
//        return userMapper.get(id);
//    }

    @CachePut(value = "user.get",key = "#user.id")
    public  User update(User user){
        userMapper.updateById(user);
        return user;
    }

    @CacheEvict(value = "user.get",key = "#id")
    public void deleteById(Integer id){
        log.info("delete invoke");
    }
}
