package mtt.ls.threadtest;

/**
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 * 1、2019年05月05天，劉松创建。
 */
public class TestRun
{
    public static void main(String[] args){
        Object lock=new Object();
        ServiceThread serviceThread=new ServiceThread(lock);
        ServiceThread serviceThread1=new ServiceThread(lock);
        serviceThread.start();
        serviceThread1.start();
    }
}
