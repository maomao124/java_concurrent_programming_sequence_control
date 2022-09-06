package mao.t2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：java并发编程_顺序控制
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 11:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                LockSupport.park();
                log.debug("t1");
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.debug("t2");
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        Thread.sleep(20);
        t2.start();

    }
}
