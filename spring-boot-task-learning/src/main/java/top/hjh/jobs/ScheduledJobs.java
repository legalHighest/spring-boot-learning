package top.hjh.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 04 14 59
 **/
@Slf4j
@Component
public class ScheduledJobs {
//    //   方法执行完5秒后继续执行
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedDelay 开始-----》" + LocalDateTime.now());
//        sleep(10 * 1000);
//        log.info("fixedDelay 结束-----》" + LocalDateTime.now());
//
//    }

//    //结束完立刻开始
//    @Scheduled(fixedRate = 3000)
//    public void fixedRateJob() throws InterruptedException {
//        log.info("fixedRate 开始-----》" + LocalDateTime.now());
//        sleep(5 * 1000);
//        log.info("fixedRate 结束-----》" + LocalDateTime.now());
//
//    }
@Scheduled(cron = "0 23 15 4 4 ?")
public void fixedCronJob() throws InterruptedException {
    log.info("生日快乐" + LocalDateTime.now());


}
}
