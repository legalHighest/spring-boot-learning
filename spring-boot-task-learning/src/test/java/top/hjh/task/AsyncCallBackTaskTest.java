package top.hjh.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 14 09
 **/
@SpringBootTest
@Slf4j
class AsyncCallBackTaskTest {
@Resource
    private  AsyncCallBackTask asyncCallBackTask;
    @Test
    void test() throws InterruptedException {
        //异步并发执行
        long start=currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.daTaskOneCallBack();
        Future<String> task2 = asyncCallBackTask.daTaskTwoCallBack();
        Future<String> task3 = asyncCallBackTask.daTaskThreeCallBack();
while (!task1.isDone() || !task2.isDone() || !task3.isDone()){
    sleep(1000);
}//只要有一个任务没结束就必须都需要等着,等一秒又返回去判断是否
        long end=currentTimeMillis();
        log.info("总耗时"+(end-start));

    }

}