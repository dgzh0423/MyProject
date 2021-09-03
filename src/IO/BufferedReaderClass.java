package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderClass {
    public static void main(String[] args) throws IOException {
        String filepath = "D:\\linux共享文件\\IO_files\\file4.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {//按行读取，效率高
                System.out.println(line);
            }
        }
    }
}
