package top.hjh.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import top.hjh.domain.User;
import top.hjh.mapper.UserMapper;

import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 19 30
 **/
@Service
public class CacheUserService implements InitializingBean {
    @Resource
    private CacheManager cacheManager;
        @Resource
        private UserMapper userMapper;

      private  Cache cache;
        public User get(Integer id){
            //通过CacheMange拿到名为user的缓存对象
//            Cache cache=cacheManager.getCache("user");

            //从Cache中尝试获取一个指定id的User类型的对象
            assert cache!=null;//这行用处不清楚
            User user =cache.get(id,User.class);

            //如果对象数据存在直接返回
            if (user!=null){
                return  user;
            }

            //如果不存在，则需要查询数据库，并将查询结果放到Cache中
            User userFromDatabase=userMapper.get(id)    ;
            cache.put(id,userFromDatabase);
            return  userFromDatabase;

        }

        public List<User> findAll(){

            Cache cache =cacheManager.getCache("users");
            assert  cache!=null;
            List<User> users=cache.get("users",List.class);
            if (users!=null){
                return  users;
            }

            List<User> usersFromDatabase=userMapper.findAll();
            cache.put("users",usersFromDatabase);
            return usersFromDatabase;
        }

        public List<User> findAllByNameLike(String name){

//            return userMapper.findAllByNameLike(name);
        return cache.get(name,()->userMapper.findAllByNameLike(name));
        }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.cache=cacheManager.getCache("user");
    }
}

