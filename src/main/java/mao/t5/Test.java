package mao.t5;

/**
 * Project name(项目名称)：java并发编程_顺序控制
 * Package(包名): mao.t5
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 12:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        ParkUnpark parkUnpark = new ParkUnpark(5);

        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                parkUnpark.print("a");
            }
        }, "t1");

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                parkUnpark.print("b");
            }
        }, "t2");

        Thread thread3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                parkUnpark.print("c");
            }
        }, "t3");

        parkUnpark.setThreads(thread1, thread2, thread3);

        parkUnpark.start();
    }
}
