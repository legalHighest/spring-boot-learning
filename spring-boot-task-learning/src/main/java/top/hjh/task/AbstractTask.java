package top.hjh.task;

import lombok.extern.slf4j.Slf4j;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 * @Author huang
 * @Description  任务抽象类
 * @Date 2023 04 04 13 46
 **/
@Slf4j
public abstract class AbstractTask {
    public  void daTaskOne() throws InterruptedException {
  log.info("开始做任务一");
        long start = currentTimeMillis();
        //执行耗时的任务
        sleep(10000);
        long end=currentTimeMillis();

        log.info("完成任务一耗时："+(end-start)+"毫秒");
    }

    public  void daTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long start = currentTimeMillis();
        //执行耗时的任务
        sleep(5000);
        long end=currentTimeMillis();

        log.info("完成任务二耗时："+(end-start)+"毫秒");
    }

    public  void daTaskThree() throws InterruptedException {
        log.info("开始做任务三");
        long start = currentTimeMillis();
        //执行耗时的任务
        sleep(3000);
        long end=currentTimeMillis();
        log.info("完成任务三耗时："+(end-start)+"毫秒");
    }
}
