package mao.t4;

import java.util.concurrent.locks.Condition;

/**
 * Project name(项目名称)：java并发编程_顺序控制
 * Package(包名): mao.t4
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 12:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition condition1 = awaitSignal.newCondition();
        Condition condition2 = awaitSignal.newCondition();
        Condition condition3 = awaitSignal.newCondition();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                awaitSignal.print("a", condition1, condition2);
            }
        }, "t1").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                awaitSignal.print("b", condition2, condition3);
            }
        }, "t2").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                awaitSignal.print("c", condition3, condition1);
            }
        }, "t3").start();

        awaitSignal.start(condition1);

    }
}
