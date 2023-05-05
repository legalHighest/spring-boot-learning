package top.hjh.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 13 59
 **/
@Component
public class AsyncTask extends AbstractTask{
    @Override
    @Async
    public void daTaskOne() throws InterruptedException {
        super.daTaskOne();
    }

    @Override
    @Async
    public void daTaskTwo() throws InterruptedException {
        super.daTaskTwo();
    }

    @Async
    @Override
    public void daTaskThree() throws InterruptedException {
        super.daTaskThree();
    }
}
