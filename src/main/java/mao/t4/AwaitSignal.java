package mao.t4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project name(项目名称)：java并发编程_顺序控制
 * Package(包名): mao.t4
 * Class(类名): AwaitSignal
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 12:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AwaitSignal extends ReentrantLock
{
    private static final Logger log = LoggerFactory.getLogger(AwaitSignal.class);

    /**
     * 循环数
     */
    private final int loopNumber;

    /**
     * 等待信号
     *
     * @param loopNumber 循环数
     */
    public AwaitSignal(int loopNumber)
    {
        this.loopNumber = loopNumber;
    }

    /**
     * 开始
     *
     * @param first 第一个
     */
    public void start(Condition first)
    {
        this.lock();
        try
        {
            log.debug("开始");
            first.signal();
        }
        finally
        {
            this.unlock();
        }
    }

    /**
     * 打印
     *
     * @param str     str
     * @param current 当前
     * @param next    下一个
     */
    public void print(String str, Condition current, Condition next)
    {
        for (int i = 0; i < loopNumber; i++)
        {
            this.lock();
            try
            {
                current.await();
                System.out.print(str);
                next.signal();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally
            {
                this.unlock();
            }
        }
    }

}
