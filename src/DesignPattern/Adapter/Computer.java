package DesignPattern.Adapter;

//电脑无法插上网线
public class Computer {

    public void surface(Adapter adapter){
        System.out.println("想上网");
        //适配器转接
        adapter.handleRequest();
    }

    public static void main(String[] args){
        Computer computer = new Computer();
        Cable cable = new Cable();
        NetAdapter netAdapter = new NetAdapter(cable);
        computer.surface(netAdapter);
    }
}
