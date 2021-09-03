package IO;

import java.io.*;

//使用 BufferedInputStream和BufferedOutputStream 拷贝二进制文件
//也可以拷贝文本文件
public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        String src = "D:\\linux共享文件\\IO_files\\1.jpg";
        String dest = "D:\\linux共享文件\\IO_files\\2.jpg";
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest))){
            byte[]buffer = new byte[1024];
            int n;
            while ((n=bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0, n);
            }
            System.out.println("拷贝完成");
        }// 编译器在此自动为我们写入finally并调用close()
    }
}
