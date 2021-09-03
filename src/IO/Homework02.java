package IO;

import java.io.*;
import java.util.Properties;

public class Homework02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\cat.properties"));

        //从cat.properties中读取属性的值
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");

        //将读取的值赋给cat对象
        Cat cat = new Cat(name, age, color);
        System.out.println(cat);

        //将cat对象序列化到file10.txt
        String dest = "D:\\linux共享文件\\IO_files\\file10.txt";
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dest))){
            objectOutputStream.writeObject(cat);
            System.out.println("序列化cat对象完成");
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(dest))){
            Cat cat1 = (Cat)(objectInputStream.readObject());
            System.out.println("反序列化cat对象完成");
            System.out.println(cat1);
        }
    }
}
class Cat implements Serializable {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
