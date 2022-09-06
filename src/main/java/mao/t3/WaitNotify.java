package mao.t3;

/**
 * Project name(项目名称)：java并发编程_顺序控制
 * Package(包名): mao.t3
 * Class(类名): WaitNotify
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 11:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class WaitNotify
{
    /**
     * 运行标记
     */
    private int flag;

    /**
     * 循环次数
     */
    private final int loopNumber;


    /**
     * Instantiates a new Wait notify.
     *
     * @param flag       the flag
     * @param loopNumber the loop number
     */
    public WaitNotify(int flag, int loopNumber)
    {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    /**
     * 打印
     *
     * @param waitFlag 等待标记
     * @param nextFlag 下一个标记
     * @param str      字符串
     */
    public void print(int waitFlag, int nextFlag, String str)
    {
        //循环
        for (int i = 0; i < loopNumber; i++)
        {
            synchronized (this)
            {
                //不是就等待
                while (this.flag != waitFlag)
                {
                    try
                    {
                        this.wait();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                //是
                //输出
                System.out.print(str);
                this.flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
