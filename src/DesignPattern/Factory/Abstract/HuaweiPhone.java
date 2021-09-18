package DesignPattern.Factory.Abstract;

public class HuaweiPhone implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("HuaweiPhone开机");
    }

    @Override
    public void shutdown() {
        System.out.println("HuaweiPhone关机");
    }

    @Override
    public void call() {
        System.out.println("HuaweiPhone打电话");
    }

    @Override
    public void sendMsg() {
        System.out.println("HuaweiPhone发信息");
    }
}
