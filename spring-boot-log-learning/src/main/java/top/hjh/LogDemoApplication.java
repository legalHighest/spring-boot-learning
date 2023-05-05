package top.hjh;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author huang
 * @Description
 * @Date ${YEAR} ${MONTH} ${DAY} ${HOUR} ${MINUTE}
 **/
@Slf4j
@SpringBootApplication
public class LogDemoApplication {

    public static void main(String[] args) {
        log.info("启动");
        SpringApplication.run(LogDemoApplication.class,args);
    }
}