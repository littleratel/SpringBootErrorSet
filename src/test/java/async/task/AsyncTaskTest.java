package async.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
        System.out.println("Invoking an asynchronous method. " + Thread.currentThread().getName());
        Future<String> future = asyncTask.asyncMethodWithReturnType();

        while (true) {
            if (future.isDone()) {
                System.out.println("Gets async task future result: " + future.get());
                break;
            }
            System.out.println("Async task not finished...");
            Thread.sleep(1500);
        }
    }

    @Test
    public void testUseThreadPoolTaskExecutor() {
        for (int i = 0; i < 1; i++) {
            System.out.println(">>> Async task: " + i);
            asyncTask.asyncMethodWithConfiguredExecutor();
        }
    }
}
