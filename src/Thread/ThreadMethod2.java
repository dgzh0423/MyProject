package Thread;

public class ThreadMethod2 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + i);
            if(i == 5){
                t2.join();
            }
        }
    }
}
class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

