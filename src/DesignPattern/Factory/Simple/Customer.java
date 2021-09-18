package DesignPattern.Factory.Simple;

public class Customer {
    public static void main(String[] args){
        //使用工厂创建车对象
        Car wl = CarFactory.getCar("wl");
        Car tesla = CarFactory.getCar("tesla");

        wl.name();
        tesla.name();
    }
}
