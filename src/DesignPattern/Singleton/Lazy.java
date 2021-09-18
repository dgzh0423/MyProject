package DesignPattern.Singleton;

//懒汉式 特点是懒，不调用getInstance() 就不会实例化
public class Lazy {

    private Lazy(){}

    //使用 volatile 的主要原因是其一个特性：禁止指令重排序优化
    private volatile static Lazy lazy;


    public static Lazy getInstance() {
        if(lazy==null){
            /* 多线程并发下有问题
             * 需要加锁，锁对象就是这个类本身*/
            synchronized(Lazy.class){
                if(lazy==null){
                    lazy = new Lazy();//不是一个原子性操作 可能会发生指令重排
                    /*
                    1.给lazy分配内存
                    2.调用构造函数，来初始化成员变量
                    3.将lazy对象指向分配的内存空间（执行完这步 lazy 就不为 null 了）*/
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args){

    }

}
