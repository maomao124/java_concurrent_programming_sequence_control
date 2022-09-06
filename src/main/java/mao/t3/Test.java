package mao.t3;

/**
 * Project name(项目名称)：java并发编程_顺序控制
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 11:17
 * Version(版本): 1.0
 * Description(描述)： 交替输出，wait notify
 */

public class Test
{
    public static void main(String[] args)
    {
        WaitNotify waitNotify = new WaitNotify(1, 5);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                waitNotify.print(1, 2, "a");
            }
        }, "t1").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                waitNotify.print(2, 3, "b");

            }
        }, "t2").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                waitNotify.print(3, 1, "c");
            }
        }, "t3").start();
    }
}
