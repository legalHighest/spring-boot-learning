package top.hjh.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 14 35
 **/
@Component
@Slf4j
public class AsyncExecutorTask extends AbstractTask{
    @Async(value = "taskExecutor")
    public Future<String> daTaskOneCallBack() throws InterruptedException {
        super.daTaskOne();
        log.info("任务一，当前线程是："+Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }


    @Async(value = "taskExecutor")
    public Future<String> daTaskTwoCallBack() throws InterruptedException {
        super.daTaskTwo();
        log.info("任务二，当前线程是："+Thread.currentThread().getName());

        return new AsyncResult<>("任务二完成");

    }

    @Async(value = "taskExecutor")
    public Future<String> daTaskThreeCallBack() throws InterruptedException {
        super.daTaskThree();
        log.info("任务三，当前线程是："+Thread.currentThread().getName());

        return new AsyncResult<>("任务三完成");

    }
}
