package DesignPattern.Factory.Abstract;

public class AppleFactory implements AbstractFactory{
    @Override
    public PhoneProduct phoneProduct() {
        return new iPhone6();
    }

    @Override
    public RouterProduct routerProduct() {
        return new Router6();
    }
}
