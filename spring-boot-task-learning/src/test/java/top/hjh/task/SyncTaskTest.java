package top.hjh.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.System.currentTimeMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 13 54
 **/
@Slf4j
@SpringBootTest
class SyncTaskTest {
    @Resource
    private SyncTask syncTask;

    @Test
    void test() throws InterruptedException {
        //异步并发执行
        long start=currentTimeMillis();
        syncTask.daTaskOne();
        syncTask.daTaskTwo();
        syncTask.daTaskThree();
        long end=currentTimeMillis();
        log.info("总耗时"+(end-start));

    }
}