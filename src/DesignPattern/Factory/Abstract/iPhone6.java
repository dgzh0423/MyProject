package DesignPattern.Factory.Abstract;

public class iPhone6 implements PhoneProduct {

    @Override
    public void start() {
        System.out.println("iPhone6开机");
    }

    @Override
    public void shutdown() {
        System.out.println("iPhone6关机");
    }

    @Override
    public void call() {
        System.out.println("iPhone6打电话");
    }

    @Override
    public void sendMsg() {
        System.out.println("iPhone6发信息");
    }
}
