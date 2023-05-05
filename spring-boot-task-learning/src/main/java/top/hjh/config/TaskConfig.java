package top.hjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author huang
 * @Description 异步任务线程池配置
 * @Date 2023 04 04 14 24
 **/
@Configuration
public class TaskConfig {
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(12);
        executor.setMaxPoolSize(26);
        executor.setQueueCapacity(2000);
        executor.setKeepAliveSeconds(120);
        executor.setWaitForTasksToCompleteOnShutdown(true);//当线程池关闭，当线程还有任务没有完成，就不会关门，运行玩再关
        executor.setAwaitTerminationSeconds(180);//线程过了多少秒还是没有运行完强制销毁，以防止线程堵塞
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
