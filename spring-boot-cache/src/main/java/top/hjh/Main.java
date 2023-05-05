package top.hjh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author huang
 * @Description
 * @Date ${YEAR} ${MONTH} ${DAY} ${HOUR} ${MINUTE}
 **/
@SpringBootApplication
@MapperScan(value = "top.hjh.mapper")
@EnableCaching
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}