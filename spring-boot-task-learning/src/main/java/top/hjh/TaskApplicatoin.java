package top.hjh;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author huang
 * @Description
 * @Date ${YEAR} ${MONTH} ${DAY} ${HOUR} ${MINUTE}
 **/
@SpringBootApplication
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = {"top.hjh.mapper"})
public class TaskApplicatoin {
    public static void main(String[] args) {

        SpringApplication.run(TaskApplicatoin.class,args);
    }
}