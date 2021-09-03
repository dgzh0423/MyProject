package IO;

import java.io.*;
//使用 BufferedReader和bufferedWriter 拷贝字符文件
//不建议拷贝声音视频文件
public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        String src = "D:\\linux共享文件\\IO_files\\file4.txt";
        String dest = "D:\\linux共享文件\\IO_files\\file5.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {//按行读取，效率高
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("拷贝完成");
        }// 编译器在此自动为我们写入finally并调用close()
    }
}
