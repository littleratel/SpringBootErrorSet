package async.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    @Async
    public Future<String> asyncMethodWithReturnType() {
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult("AsyncTask execute successful!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execute method with configured executor - " + Thread.currentThread().getName());
    }

}
