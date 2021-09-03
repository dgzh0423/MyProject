package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> cls = Class.forName("Reflection.PrivateTest");
        Object o = cls.getDeclaredConstructor().newInstance();

        Method method = cls.getMethod("getName");
        System.out.println(method.invoke(o));

        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"hello");
        System.out.println(method.invoke(o));
    }
}

class PrivateTest{
    private String name = "hello kitty";
    public String getName() {
        return name;
    }
}
