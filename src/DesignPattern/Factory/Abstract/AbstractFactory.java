package DesignPattern.Factory.Abstract;

//抽象产品工厂
public interface AbstractFactory {
    //生产手机
    PhoneProduct phoneProduct();
    //生产路由器
    RouterProduct routerProduct();
}
