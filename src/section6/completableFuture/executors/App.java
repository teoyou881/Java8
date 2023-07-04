package section6.completableFuture.executors;

import javax.print.attribute.standard.SheetCollate;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        //executor shutdown is graceful shutdown.
        //This means handling logic well and terminating it with as few side effects as possible when the program exits.
        executorService.shutdown();


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.submit(getRunnable("a"));
        fixedThreadPool.submit(getRunnable("b"));
        fixedThreadPool.submit(getRunnable("c"));
        fixedThreadPool.submit(getRunnable("d"));
        fixedThreadPool.submit(getRunnable("e"));
        fixedThreadPool.shutdown();


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(getRunnable("schedule"),1, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    private static Runnable getRunnable(String msg) {
        return () -> System.out.println(msg + Thread.currentThread().getName());
    }
}
