package Thread;

public class ThreadMethod1 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("Thread");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("main thread...");
        }
        t1.interrupt();
    }
}
class T1 extends Thread{
    @Override
    public void run() {
        if (!isInterrupted()) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            try {
                Thread.sleep(20000);//休眠20s
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            }
        }
    }
}
