package Thread;

public class Homework02 {
    public static void main(String[] args) {
        Thread p1 = new Thread(new takeMoney());
        p1.setName("p1");
        Thread p2 = new Thread(new takeMoney());
        p2.setName("p2");
        p1.start();
        p2.start();
    }
}
class takeMoney implements Runnable {
    private static int money = 10000;
    private static boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足！");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取了1000 余额：" + money);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
