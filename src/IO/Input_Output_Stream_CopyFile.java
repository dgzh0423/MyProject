package IO;

import java.io.*;

public class Input_Output_Stream_CopyFile {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = new FileInputStream("D:\\linux共享文件\\新建文本文档.txt");
            outputStream = new FileOutputStream("D:\\linux共享文件\\IO_files\\file2.txt");
            int n;
            byte[] buffer = new byte[20];
            while((n = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, n);//边读边写
            }
            System.out.println("拷贝成功");
        }finally {
            if(inputStream != null) {
                inputStream.close();
            }
            if(outputStream != null) {
                outputStream.close();
            }
        }
    }
}
