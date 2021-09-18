package DesignPattern.Factory.Abstract;

public class Client {
    public static void main(String[] args){
        AppleFactory appleFactory = new AppleFactory();
        PhoneProduct phoneProduct = appleFactory.phoneProduct();
        phoneProduct.sendMsg();
        RouterProduct routerProduct = appleFactory.routerProduct();
        routerProduct.openWifi();

        System.out.println();

        HuaweiFactory huaweiFactory = new HuaweiFactory();
        PhoneProduct phoneProduct1 = huaweiFactory.phoneProduct();
        phoneProduct1.sendMsg();
        RouterProduct routerProduct1 = huaweiFactory.routerProduct();
        routerProduct1.openWifi();

    }
}
