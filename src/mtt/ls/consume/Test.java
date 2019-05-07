package mtt.ls.consume;

/**
 * 使用wait和notify
 */
public class Test {
    private static Integer count=0;
    private static String lock="LOCK";
    class Product implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                //每100ms生产10个产品
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){

                //判断资源已满
                while (count>=10) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
                //开始干活
                count++;
                System.out.println(Thread.currentThread().getName()+"生产了产品,现在共有"+count+"产品");
                //唤醒其他进程
                lock.notifyAll();
                }

            }
        }
    }

    /**
     * 消费者进程
     */
    class Consume implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                //每个100ms消费一个产品
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){
                    //判断是否为空,为空睡觉
                    while (count<=0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //干活，消费产品
                    count--;
                    System.out.println(Thread.currentThread().getName()+"已消费产品,还剩余"+count+"个产品");
                    lock.notify();
                }
            }

        }
    }
    public static void main(String[] args){
        Test test=new Test();
        for (int i = 0; i <5 ; i++) {
            new Thread(test.new Product()).start();
            new Thread(test.new Consume()).start();
        }
    }
}
