package top.hjh.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.hjh.domain.User;
import top.hjh.mapper.UserMapper;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 21 01
 **/
@Service
@Slf4j
public class RedisCacheService {
    @Resource
    private UserMapper userMapper;
    @Cacheable(value = "getName")
    public  String getName(Integer i){
        log.info("getName invoke......");
        return "name"+i;
    }

    @Cacheable(value = "getUser",cacheManager = "userCacheManager")
    public User getUser(Integer id) {
        return userMapper.get(id);
    }

}
