package DesignPattern.Factory.Method;

import DesignPattern.Factory.Simple.CarFactory;

public class Customer {
    public static void main(String[] args){
        Car car = new WuLingFactory().getCar();
        Car car1 = new TeslaFactory().getCar();
        car.name();
        car1.name();
    }
}
