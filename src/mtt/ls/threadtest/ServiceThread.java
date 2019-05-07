package mtt.ls.threadtest;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月05天，劉松创建。
 */
public class ServiceThread extends Thread
{
    private Object lock;
    public ServiceThread(Object lock){
        this.lock=lock;
    }
    @Override
    public void run()
    {
        super.run();
        new Service().testWait(lock);
    }
}
