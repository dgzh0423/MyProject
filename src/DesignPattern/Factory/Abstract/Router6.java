package DesignPattern.Factory.Abstract;

public class Router6 implements RouterProduct{
    @Override
    public void start() {
        System.out.println("Router6开机");
    }

    @Override
    public void shutdown() {
        System.out.println("Router6关机");
    }

    @Override
    public void openWifi() {
        System.out.println("Router6打开WiFi");
    }

    @Override
    public void setting() {
        System.out.println("Router6设置");
    }
}
