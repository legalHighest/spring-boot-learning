package top.hjh.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 18 28
 **/
@Slf4j
public class MyListener1  implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {

        log.info(String.format("%s 监听到事件源1 ：%s",MyListener1.class.getName(),event.getSource()));
    }
}
