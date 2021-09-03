package Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionDog {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1.使用Properties读取dog.properties
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\dog.properties"));
        String classFullPath = properties.getProperty("classFullPath");
        String methodName = properties.getProperty("methodName");
        System.out.println("classFullPath = " + classFullPath);
        System.out.println("methodName = " + methodName);
        System.out.println();

        //2.使用反射机制
        //2.1加载类,返回Class类型的对象
        Class<?> cls= Class.forName(classFullPath);

        //2.2 通过cls得到Dog的对象实例o
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println("o的运行类型是 " + o.getClass());
        //判断一个实例是否是某个类型时，正常情况下，使用instanceof操作符
        boolean isDog = o instanceof Dog;
        System.out.println(isDog);

        //2.3 通过cls得到Dog的methodName的方法对象
        //在反射中，可以把方法视为对象
        //getMethod(name, Class...)：获取某个public的Method（包括父类）
        //getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
        Method method = cls.getMethod(methodName);

        //2.4 通过method这个方法对象来调用方法
        //方法.invoke(对象)
        method.invoke(o);
        System.out.println();


        //Field getField(name)：根据字段名获取某个public的field（包括父类）
        //Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);//调用Field.setAccessible(true)的意思是，别管这个字段是不是public，一律允许访问
        //name.set(o, "阿黄");
        Object o1 = name.get(o);
        System.out.println(o1);

        System.out.println(name.getModifiers());//int形式返回Field的修饰符
        System.out.println(name.getType());//以Class形式返回类型
        System.out.println(name.getName());//返回属性名

    }
}
