package top.hjh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import top.hjh.listener.MyEvent;
import top.hjh.listener.MyListener1;

/**
 * @Author huang
 * @Description
 * @Date ${YEAR} ${MONTH} ${DAY} ${HOUR} ${MINUTE}
 **/
//进行自动注册即可
@ServletComponentScan
@SpringBootApplication
public class SpringApplications {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(SpringApplications.class,args);
        context.addApplicationListener(new MyListener1());//listener1缺点自己需要new，容易空间问题
        context.publishEvent(new MyEvent("测试事件 "));
    }
}