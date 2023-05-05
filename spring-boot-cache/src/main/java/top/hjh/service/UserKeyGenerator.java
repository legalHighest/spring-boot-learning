package top.hjh.service;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.sql.Statement;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 16 20 12
 **/
public class UserKeyGenerator implements KeyGenerator {


    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName() + params[0];
    }
}
