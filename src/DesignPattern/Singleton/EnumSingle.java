package DesignPattern.Singleton;

//enum 是什么？本身也是一个class类

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
class Test{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        System.out.println(instance1);

        /*通过反射破解枚举发现不成功：
          1、普通的反编译会欺骗开发者，说enum枚举是无参构造
          2、实际enum为有参构造(String s, int i)
          3、通过反射破解枚举会发现抛出异常*/
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle = declaredConstructor.newInstance();
        System.out.println(enumSingle);
    }
}
