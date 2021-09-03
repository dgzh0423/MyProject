package Thread;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread test = new Thread(new Test());
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i==5){
                test.start();
                test.join();
            }
        }
        System.out.println("主线程结束");
    }
}
class Test implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <=10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello " + i);
        }
        System.out.println("子线程结束");
    }
}
