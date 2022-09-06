package mao.t5;

import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：java并发编程_顺序控制
 * Package(包名): mao.t5
 * Class(类名): ParkUnpark
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 12:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ParkUnpark
{
    /**
     * 循环数
     */
    private final int loopNumber;
    /**
     * 线程数组
     */
    private Thread[] threads;

    public ParkUnpark(int loopNumber)
    {
        this.loopNumber = loopNumber;
    }

    /**
     * 设置线程
     *
     * @param threads 线程
     */
    public void setThreads(Thread... threads)
    {
        this.threads = threads;
    }

    /**
     * 打印
     *
     * @param str str
     */
    public void print(String str)
    {
        for (int i = 0; i < loopNumber; i++)
        {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(nextThread());
        }
    }

    /**
     * 下一个线程
     *
     * @return {@link Thread}
     */
    private Thread nextThread()
    {
        Thread current = Thread.currentThread();
        int index = 0;

        for (int i = 0; i < threads.length; i++)
        {
            if (threads[i] == current)
            {
                index = i;
                break;
            }
        }
        if (index < threads.length - 1)
        {
            return threads[index + 1];
        }
        else
        {
            return threads[0];
        }
    }

    /**
     * 开始
     */
    public void start()
    {
        for (Thread thread : threads)
        {
            thread.start();
        }
        LockSupport.unpark(threads[0]);
    }
}
