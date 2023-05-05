package top.hjh.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 19 03
 **/
@Slf4j
@Component
public class MyListener4 {
    @EventListener
    public  void listener(MyEvent event){
        log.info(String.format("%s 监听到事件源4 ：%s",MyListener4.class.getName(),event.getSource()));
    }
}
