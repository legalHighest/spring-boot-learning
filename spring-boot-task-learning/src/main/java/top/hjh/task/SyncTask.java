package top.hjh.task;

import org.springframework.stereotype.Component;

/**
 * @Author huang
 * @Description 同步任务调用子类
 * @Date 2023 04 04 13 52
 **/
@Component
public class SyncTask extends AbstractTask{
    @Override
    public void daTaskOne() throws InterruptedException {
        super.daTaskOne();
    }

    @Override
    public void daTaskTwo() throws InterruptedException {
        super.daTaskTwo();
    }

    @Override
    public void daTaskThree() throws InterruptedException {
        super.daTaskThree();
    }
}
