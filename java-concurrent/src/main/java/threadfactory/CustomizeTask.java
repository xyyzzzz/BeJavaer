package threadfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class CustomizeTask implements Runnable {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private int num;

    public CustomizeTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        logger.info("Task " + num + " is running " + new Date());
        try {
            Thread.sleep(2 * 10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info("Task " + num + " is end " + new Date());
    }

}