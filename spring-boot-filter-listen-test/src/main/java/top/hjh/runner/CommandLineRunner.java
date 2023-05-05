package top.hjh.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 19 25
 **/
@Slf4j
@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineStarupRunner传入参数:{}", Arrays.toString(args));
    }
}
