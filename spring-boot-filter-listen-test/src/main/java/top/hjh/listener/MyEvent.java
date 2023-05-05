package top.hjh.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 18 24
 **/
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source){
        super(source);//

    }
}//因为继承了ApplicationEvent
