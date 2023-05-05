package top.hjh.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 18 57
 **/
@Slf4j
@Component
//这个注解自动将类装装载进容器
public class MyListener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源2 ：%s",MyListener2.class.getName(),event.getSource()));
    }
}
