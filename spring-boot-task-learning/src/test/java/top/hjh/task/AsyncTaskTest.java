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
 * @Date 2023 04 04 14 01
 **/
@Slf4j
@SpringBootTest
class AsyncTaskTest {
    @Resource
    private  AsyncTask asyncTask;
@Test
    public  void test() throws InterruptedException {
    long start=currentTimeMillis();
    asyncTask.daTaskOne();
    asyncTask.daTaskTwo();
    asyncTask.daTaskThree();
    long end=currentTimeMillis();
    log.info("总耗时"+(end-start));
}
}