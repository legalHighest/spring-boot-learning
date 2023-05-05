package top.hjh.log.annotation;

import java.lang.annotation.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 03 16 10
 **/
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
//生成文档
public @interface MyLog {
//    操作事件
    String operation () default "";

//    日志类型
    int type();
}
