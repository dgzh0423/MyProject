package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

//字节流 InputStream 和 OutputStream
public class Input_Output_StreamFile {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\linux共享文件\\IO_files\\file1.txt");
        f1.createNewFile();//创建File

        //read()会读取输入流的下一个字节，并返回字节表示的int值（0~255）。如果已读到末尾，返回-1表示不能继续读取了
        try(InputStream input = new FileInputStream("D:\\linux共享文件\\IO_files\\file1.txt")){
            int n;//不能写int n = input.read()，因为read()方法是阻塞的。它的意思是必须等read()方法返回后才能继续
            byte[] buffer = new byte[10];//read(byte[] b) 提高输入效率
            while((n = input.read(buffer)) != -1){
                System.out.println("read " + n + " bytes: " + new String(buffer,0, n));
            }
        }// 编译器在此自动为我们写入finally并调用close()


        //OutputStream还提供了一个flush()方法，它能强制把缓冲区内容输出。
        //操作系统是把输出的字节先放到内存的一个缓冲区里（本质上就是一个byte[]数组），等到缓冲区写满了，再一次性写入文件或者网络
        try(OutputStream output = new FileOutputStream("D:\\linux共享文件\\IO_files\\file1.txt")){
            output.write("Hello".getBytes(StandardCharsets.UTF_8));
        }// 编译器在此自动为我们写入finally并调用close()
    }
}

