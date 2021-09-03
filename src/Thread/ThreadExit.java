package Thread;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        t1.start();
        Thread.sleep(10*1000);//main线程休眠10s
        //如果希望main线程控制t1线程的终止，需要修改loop
        //让t1退出run(), 从而终止thread线程 -> 通知方式
        t1.setLoop(false);
    }
}

class Thread1 extends Thread {
    private int count = 0;
    private volatile boolean loop = true;
    @Override
    public void run() {
        while(loop) {
            System.out.println("Thread " + (++count));
            //然后让线程休眠一秒
            try {
                Thread.sleep(500);//休眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
