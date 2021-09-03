package Reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cls = Class.forName("java.io.File");
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor c : declaredConstructors){
            System.out.println("File.class的构造器有：" + c);
        }

        String filepath = "D:\\linux共享文件\\reflection_homework.txt";
        Object o = cls.getDeclaredConstructor(String.class).newInstance(filepath);//创建File对象
        System.out.println(o.getClass());

        Method createNewFile = cls.getMethod("createNewFile");
        createNewFile.invoke(o);
        System.out.println("创建成功");
    }
}
