package top.hjh.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 19 01
 **/

@Slf4j
public class MyListener3  implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源3 ：%s",MyListener3.class.getName(),event.getSource()));
    }
}
