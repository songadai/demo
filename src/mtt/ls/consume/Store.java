package mtt.ls.consume;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 单例模式下的资源类
 */
public class Store {
    private static AtomicInteger count=new AtomicInteger(0);
    private static Store store=new Store();
    private Store(){

    }

    public static Store getStore() {
        return store;
    }

    public void decrease() {
        count.getAndDecrement();
    }

    public void increase() {
      count.getAndIncrement();
    }
    public Integer get(){
        return count.get();
    }

}
