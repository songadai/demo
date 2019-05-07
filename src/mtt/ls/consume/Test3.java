package mtt.ls.consume;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用阻塞队列实现生产者消费者模型
 */
public class Test3 {
    private static Integer count=0;
    private static BlockingQueue blockingQueue=new ArrayBlockingQueue<>(10);
    class Product implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    blockingQueue.put(1);
                    System.out.println("还有"+blockingQueue.size()+"个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consume implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    blockingQueue.take();
                    System.out.println("还有"+blockingQueue.size()+"个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        Test3 test=new Test3();
        for (int i = 0; i <5 ; i++) {
            new Thread(test.new Product()).start();
            new Thread(test.new Consume()).start();
        }
    }

}
