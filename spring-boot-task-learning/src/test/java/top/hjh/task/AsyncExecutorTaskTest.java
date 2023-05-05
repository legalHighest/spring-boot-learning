package top.hjh.task;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 14 38
 **/
@SpringBootTest
class AsyncExecutorTaskTest {
@Resource
    private  AsyncExecutorTask task;

@Test
    public  void test() throws InterruptedException {
    //异步并发执行
    long start=currentTimeMillis();
    Future<String> task1 = task.daTaskOneCallBack();
    Future<String> task2 = task.daTaskTwoCallBack();
    Future<String> task3 = task.daTaskThreeCallBack();
    sleep(1000*10);


}
}