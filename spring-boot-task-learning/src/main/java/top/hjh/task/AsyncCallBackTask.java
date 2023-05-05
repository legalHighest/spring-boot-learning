package top.hjh.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 14 05
 **/
@Component
public class AsyncCallBackTask extends AbstractTask{

    @Async
    public Future<String> daTaskOneCallBack() throws InterruptedException {
        super.daTaskOne();
    return new AsyncResult<>("任务一完成");
    }


    @Async
    public Future<String> daTaskTwoCallBack() throws InterruptedException {
        super.daTaskTwo();
        return new AsyncResult<>("任务二完成");

    }

    @Async
    public Future<String> daTaskThreeCallBack() throws InterruptedException {
        super.daTaskThree();
        return new AsyncResult<>("任务三完成");

    }
}
