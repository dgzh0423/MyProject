package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterClass {
    public static void main(String[] args) throws IOException {
        String filepath = "D:\\linux共享文件\\IO_files\\file5.txt";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))) {
            bufferedWriter.write("Hello Jack \n");
            bufferedWriter.write("Hi Tom \n");
            System.out.println("写入成功");
        }
    }
}
