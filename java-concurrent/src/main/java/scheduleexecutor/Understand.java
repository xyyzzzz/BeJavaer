package scheduleexecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author CNan
 */
public class Understand {

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("准备执行线程1");
                        System.out.println("准备执行线程2");
                        System.out.println("准备执行线程3");
                        Thread t = new Thread(r);

                        return t;
                    }
                });

        Long now = System.currentTimeMillis();
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("定时执行任务开始 " + count.incrementAndGet());
            try {
                System.out.println("开始睡眠2秒");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("定时执行任务结束 " + count.get());
        }, 0, 5000, TimeUnit.MILLISECONDS);

        System.out.println(count.get());
    }

}
