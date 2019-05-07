package mtt.ls.threadtest;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月05天，劉松创建。
 */
public class Service
{
    /**
     * 测试等待
     * @param lock
     */
    public void testWait(Object lock)
    {

        try
        {
            synchronized (lock)
            {
                System.out.println("wait begin");
                lock.wait();
                System.out.println("wait end");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 测试唤醒
     * @param lock
     */
    public void testnotify(Object lock)
    {
        try
        {
            synchronized (lock){
                System.out.println("begin notify："+Thread.currentThread().getName());
                lock.notify();
                Thread.sleep(1000);
                System.out.println("end notify："+Thread.currentThread().getName());

            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
