package DesignPattern.Factory.Simple;

public class CarFactory {
    public static Car getCar(String car){
        if(car == "wl")
            return new WuLing();
        else if (car == "tesla")
            return new Tesla();
        else
            return null;
    }

    //方法二
    public static Car getWuLing(){
        return new WuLing();
    }

    public static Car getTesla(){
        return new Tesla();
    }
}
