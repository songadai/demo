package mtt.ls.consume;

public class Product implements Runnable{

    @Override
    public void run() {
       while (true){
           //每个线程生产十个产品
           for (int i = 0; i <10 ; i++) {

               //生产一个产品需要100ms
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               //判断是否已满
               while(Store.getStore().get()>=10){
                   //满了，则睡眠
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               };
               synchronized (this) {
                   Store.getStore().increase();
                   System.out.println(Thread.currentThread().getName() + "正在生产");
               }
           }
       }
    }
}
