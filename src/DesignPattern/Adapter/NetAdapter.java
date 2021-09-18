package DesignPattern.Adapter;

//实际工作的适配器 需要连接网线和电脑
//通过组合实现适配器能上网的功能
public class NetAdapter implements Adapter{

    private Cable cable;

    public NetAdapter(Cable cable) {
        this.cable = cable;
    }

    @Override
    public void handleRequest() {
        cable.request();
    }
}
