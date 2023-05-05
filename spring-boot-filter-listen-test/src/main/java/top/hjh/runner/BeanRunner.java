package top.hjh.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 19 32
 **/
@Configuration
@Slf4j
public class BeanRunner {
@Bean
@Order(1)
 public CommandLineRunner runner1(){
    return new CommandLineRunner(){
        @Override
        public void run(String... args) throws Exception {
            log.info("BeanCommandLineRunner run1()"+ Arrays.toString(args));
        }
    };
}


    @Bean
    @Order(2)
    public CommandLineRunner runner2(){
        return new CommandLineRunner(){
            @Override
            public void run(String... args) throws Exception {
                log.info("BeanCommandLineRunner run2()"+ Arrays.toString(args));
            }
        };
    }


    @Bean
    @Order(3)
    public ApplicationRunner runner3(){
    return new ApplicationRunner() {
        @Override
        public void run(ApplicationArguments args) throws Exception {
            log.info("BeanApplicationRunner run3"+Arrays.toString(args.getSourceArgs()));
        }
    };
    }
}
