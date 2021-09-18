package DesignPattern.Singleton;

//内部静态类
public class InnerStatic {

    private InnerStatic(){}

    public static InnerStatic getInstance() {
        return InnerClass.instance;
    }

    public static class InnerClass{
        private static final InnerStatic instance = new InnerStatic();
    }
}
