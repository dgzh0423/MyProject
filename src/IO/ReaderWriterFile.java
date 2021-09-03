package IO;

import java.io.*;

//字符流Reader，Writer
public class ReaderWriterFile {
    public static void main(String[] args) throws IOException {
        String filepath = "D:\\linux共享文件\\IO_files\\file3.txt";

        try(Writer writer = new FileWriter(filepath, true)){//默认是覆盖模式,这里true指定追加模式
            String s = "hello";
            writer.write(s);
            System.out.println("写入成功");
        }// 编译器在此自动为我们写入finally并调用close()

        try(Reader reader = new FileReader(filepath)){
            char[] buffer = new char[1000];
            int n;
            while ((n = reader.read(buffer))!= -1){
                System.out.println(new String(buffer,0, n));
            }
        }// 编译器在此自动为我们写入finally并调用close()
    }
}
