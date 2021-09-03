package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//Properties父类是Hashtable，底层就是Hashtable核心方法
public class PropertiesClass {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //加载配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //根据key获取对应的value
        System.out.println("用户名 = " + properties.getProperty("user"));

        //设置k-v对
        //如果没有k-v对，就是创建
        //如果有的话，就是修改
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "董浩");
        //保存设置
        properties.store(new FileWriter("src\\mysql.properties"),null);

        properties.list(System.out);
    }
}
