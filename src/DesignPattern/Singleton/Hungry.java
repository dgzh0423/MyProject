package DesignPattern.Singleton;

//饿汉式单例
//特点是饿，一上来我就要吃（实例化）
public class Hungry {

    private Hungry(){}

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance(){
        return hungry;
    }
}
