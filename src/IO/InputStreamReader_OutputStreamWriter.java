package IO;

import java.io.*;

//字节流包装成字符流,解决乱码问题
public class InputStreamReader_OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        String filepath = "D:\\linux共享文件\\IO_files\\file7.txt";

        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath,true),"UTF-8"))) {
            bufferedWriter.newLine();
            bufferedWriter.write("Hi, 董浩");
            System.out.println("写入成功");
        }
        //FileInputStream -> InputStreamReader -> BufferedReader
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF-8"))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("读取成功");
        }
    }
}
