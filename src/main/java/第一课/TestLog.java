package 第一课;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 设置以日志的方式输出  调整输出格式
 */
public class TestLog {
    static Logger logger = LogManager.getLogger(TestLog.class);
    /**
     * log输出测试
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("传统输出");

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
        new Thread(()->{logger.info("线程 info");}).start();

    }



}
