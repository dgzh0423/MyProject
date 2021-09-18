package DesignPattern.Factory.Abstract;

public class HuaweiRouter implements RouterProduct{
    @Override
    public void start() {
        System.out.println("HuaweiRouter开机");
    }

    @Override
    public void shutdown() {
        System.out.println("HuaweiRouter关机");
    }

    @Override
    public void openWifi() {
        System.out.println("HuaweiRouter打开WiFi");
    }

    @Override
    public void setting() {
        System.out.println("HuaweiRouter设置");
    }
}
