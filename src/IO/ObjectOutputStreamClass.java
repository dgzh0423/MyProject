package IO;

import java.io.*;
//使用ObjectOutputStream完成数据的序列化(保存数据和其数据类型)
public class ObjectOutputStreamClass {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的文件格式不是由用户决定的
        String dest = "D:\\linux共享文件\\IO_files\\file6.txt";
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dest))){
            //序列化数据到dest
            //Integer,Boolean Character,Double,String 实现了Serializable接口
            objectOutputStream.writeInt(100);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeChar('x');
            objectOutputStream.writeDouble(9.2);
            objectOutputStream.writeUTF("Tom");

            //保存一个Dog对象,Dog类要implements Serializable
            objectOutputStream.writeObject(new Dog("阿黄", 3, "黄色","中国"));

            System.out.println("保存完成");
        }
    }
}

class Dog implements Serializable{
    private String name;
    private int age;

    //序列化对象时，默认将所有属性都序列化，除了static和transient修饰的成员
    private transient String color;
    private static String nation;

    //序列化对象时，里面属性的类型也要实现序列化接口

    //序列化的版本号
    @Serial
    private static final long serialVersionUID =1L;

    public Dog(String name, int age, String color, String nation) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Dog.nation = nation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", nation='" + nation + '\''+
                '}';
    }
}
