package mtt.ls.consume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用可重入锁
 */
public class Test2
{
    private static Lock lock = new ReentrantLock();

    private static Integer count = 0;

    private static Condition notFull = lock.newCondition();

    private static Condition notEmpty = lock.newCondition();

    class Product implements Runnable
    {
        @Override
        public void run()
        {
            //一个线程生产十个产品,生产一个产品要100ms
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                try
                {
                    lock.lock();
                    while (count >= 10)
                    {
                        try
                        {
                            notFull.wait();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(
                            Thread.currentThread().getName() + "生产了一个产品,还有" +
                                    count + "产品");
                    notEmpty.signalAll();
                }
                finally
                {
                    lock.unlock();
                }
            }
        }
    }

    class Consume implements Runnable
    {

        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                try
                {
                    lock.lock();
                    while (count <= 0)
                    {
                        try
                        {
                            notEmpty.await();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(
                            Thread.currentThread().getName() + "消费了一个产品,还有" +
                                    count + "产品");
                    notFull.signal();
                }
                finally
                {
                    lock.unlock();
                }

            }
        }
    }

    public static void main(String[] args)
    {
        Test2 test = new Test2();
        for (int i = 0; i < 5; i++)
        {
            new Thread(test.new Product()).start();
            new Thread(test.new Consume()).start();
        }
    }
}
