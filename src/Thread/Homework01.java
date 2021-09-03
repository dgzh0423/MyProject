package Thread;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        A aa = new A();
        Thread a = new Thread(aa);
        Thread b = new Thread(new B(aa));
        a.start();
        b.start();
    }
}
class A implements Runnable {
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class B implements Runnable {
    private A aa;
    private Scanner scanner = new Scanner(System.in);

    public B(A aa) {//构造器中直接传入A类的对象
        this.aa = aa;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q/q以退出线程a：");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q') {
                aa.setFlag(false);
                System.out.println("线程B退出");
                break;
            }
        }
    }
}
