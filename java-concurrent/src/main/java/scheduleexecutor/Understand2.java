package scheduleexecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author CNan
 */
public class Understand2 {

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });


        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时执行任务开始 "+count.incrementAndGet());
                try {
                    System.out.println("开始睡眠1一秒");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("定是执行任务结束 "+count.get());
            }
        },0,400, TimeUnit.MILLISECONDS);


        System.out.println(count.get());
    }

}
