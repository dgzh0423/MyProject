package DesignPattern.Factory.Abstract;

public class HuaweiFactory implements AbstractFactory{
    @Override
    public PhoneProduct phoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
