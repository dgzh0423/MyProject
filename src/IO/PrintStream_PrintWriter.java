package IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

//打印流只有输出流
public class PrintStream_PrintWriter {
    public static void main(String[] args) throws FileNotFoundException {
        String dest = "D:\\linux共享文件\\IO_files\\file8.txt";
        try(PrintStream printStream = new PrintStream(dest)){
            printStream.println("hello, Tom");
        }
        try(PrintWriter printWriter = new PrintWriter(dest)){
            printWriter.println("hi, 董浩");
        }
    }
}
