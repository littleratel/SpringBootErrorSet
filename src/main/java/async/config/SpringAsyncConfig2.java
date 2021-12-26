package async.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//@Configuration
//@EnableAsync
public class SpringAsyncConfig2 implements AsyncConfigurer {

    @Bean(name = "threadPoolTaskExecutor")
    public Executor getAsyncExecutor() {
        System.out.println("=====>>> SpringAsyncConfig2 create bean ThreadPoolTaskExecutor");
        return new ThreadPoolTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
}
