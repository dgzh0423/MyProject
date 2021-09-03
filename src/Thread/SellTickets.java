package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTickets {
    public static void main(String[] args) {
        /*
        Thread t1 = new Thread(new SellTickets01());
        Thread t2 = new Thread(new SellTickets01());
        Thread t3 = new Thread(new SellTickets01());
        t1.start();
        t2.start();
        t3.start();
         */
        Thread t11 = new Thread(new SellTickets02());
        Thread t22 = new Thread(new SellTickets02());
        Thread t33 = new Thread(new SellTickets02());
        t11.start();
        t22.start();
        t33.start();
    }
}

//使用Thread和Runnable都会出现超卖现象，因为三个线程同时进入了tickets <= 0的判断条件
class SellTickets01 extends Thread{
    private static int tickets = 20;
    @Override
    public void run() {
        while (true) {
            if (tickets <= 0){
                System.out.println("售罄");
                break;
            }
            try {
                Thread.sleep(1000);//休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票，剩余票数 " + (--tickets));
        }
    }
}

//使用synchronized关键字解决线程同步问题
class SellTickets02 implements Runnable{
    private static int tickets = 50;
    private static boolean hasTicket = true;

    //ReentrantLock可以替代synchronized进行同步
    //必须先获取到锁，再进入try {...}代码块，最后使用finally保证释放锁；
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        /*
        while (hasTicket){
            sell();
        }
         */
        while (hasTicket) {
            lock.lock();
            try {
                sell();
            } finally {
                lock.unlock();
            }
        }
    }
    //同步方法是静态的，锁为当前类本身XXX.class
    //在静态方法中实现一个同步代码块
    /*
        public static void m(){
            synchronized(SellTickets02.class){
                System.out.println();
            }
        }
     */
    public /* synchronized*/ void sell(){//同步方法，此时锁在this对象上。在同一时刻，只能有一个线程执行run()
        if (tickets == 0){
            System.out.println("售罄");
            hasTicket = false;
            return;
        }
        System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票，剩余票数 " + (--tickets));
        try {
            Thread.sleep(1000);//休眠50ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

