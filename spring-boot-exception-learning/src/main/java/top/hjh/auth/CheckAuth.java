package top.hjh.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 19 48
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuth {
    String value();
}
