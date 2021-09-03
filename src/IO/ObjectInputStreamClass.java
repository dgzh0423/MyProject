package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//使用ObjectInputStream完成反序列化，将数据读取到程序
public class ObjectInputStreamClass {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        String src = "D:\\linux共享文件\\IO_files\\file6.txt";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(src))){
            //读取(反序列化)的顺序要和保存(序列化)的顺序一致
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readUTF());

            Object o = objectInputStream.readObject();
            System.out.println(o);
            //如果我们想要调用Dog的方法，就要向下转型
            //需要将Dog类复制到可以引用的位置
            Dog dog = (Dog)o;
            System.out.println(dog.getName());
            System.out.println(dog.getColor());
            System.out.println(dog.getNation());

            System.out.println("读取成功");
        }
    }
}
