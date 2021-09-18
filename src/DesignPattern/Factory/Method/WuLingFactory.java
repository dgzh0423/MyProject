package DesignPattern.Factory.Method;

public class WuLingFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new WuLing();
    }
}
