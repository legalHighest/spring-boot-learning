package top.hjh.listener;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 19 49
 **/
@Component
@Slf4j
public class BeanInitListener  implements InitializingBean {

    static {
        log.info("类初始化静态代码块");
    }
    public  BeanInitListener(){
        log.info("类初始化构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("类初始化 afterPropertiesSet方法");
    }

    @PostConstruct
    void method(){
        log.info("类初始化 postConstruct 注解方法!");
    }
}
