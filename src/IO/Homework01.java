package IO;

import java.io.*;

//使用BufferedReader读取一个文本文件，为每行加上行号，在连同内容输出
public class Homework01 {
    public static void main(String[] args) throws IOException {
        String src = "D:\\linux共享文件\\IO_files\\file9.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(src))){
            String line;
            int lineNumber = 0;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println((++lineNumber) + line);
            }
        }
    }
}
