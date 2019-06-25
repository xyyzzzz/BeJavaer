package threadfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadFactoryTest {

    protected static Logger logger = LoggerFactory.getLogger(ThreadFactoryTest.class);

    public static void main(String[] args) {
        logger.info("Main thread beging");

        CustomizeThreadFactory factory = new CustomizeThreadFactory("MyThreadFactory");

        for (int i = 0; i < 10; i++) {
            Thread thread = factory.newThread(new CustomizeTask(i));
            thread.start();
        }
        logger.info("Factory stats:\n");
        logger.info("%s\n", factory.getStas());

        logger.info("main thread end");
    }

}