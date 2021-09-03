package Thread;

public class SimpleThread {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start(); //t1.run(): 直接调用run()方法，相当于调用了一个普通的Java方法,并没有创建新线程

        ThreadProxy threadProxy = new ThreadProxy(new MyRunnable());
        threadProxy.start();

        //lambda语法创建线程
        Thread t3 = new Thread(()-> System.out.println("start Thread3"));
        t3.start();

        DaemonThread daemonThread = new DaemonThread();
        //设置守护进程
        // 当其他进程结束时，守护进程会自动结束
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}

//继承Thread类,实际上Thread类里的run()也是重写了Runnable接口的run();
class MyThread extends Thread {
    int count = 0;
    @Override
    public void run() {
        while(true) {
            System.out.println("Thread1 " + (++count));
            //然后让线程休眠一秒
            try {
                Thread.sleep(1000);//休眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10){
                break;
            }
        }
    }
}

//线程代理类。模拟一个极简的Thread类
class ThreadProxy implements Runnable {
    private Runnable target = null;//属性，类型是Runnable

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start(){
        start0();
    }
    public void start0(){
        run();
    }
    @Override
    public void run() {
        if (target != null){
            target.run();//动态绑定，运行类型是MyRunnable
        }
    }
}
//实现Runnable接口
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start Thread2");
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon Thread is running");
        }
    }
}
