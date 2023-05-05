package top.hjh.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 19 27
 **/
@Component
@Slf4j
public class AppStarupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner参数名称:{}",args.getOptionNames());
        log.info("ApplicationRunner参数名称:{}",args.getOptionValues("age"));
        log.info("ApplicationRunner参数名称:{}", Arrays.toString(args.getSourceArgs()));

    }
}
