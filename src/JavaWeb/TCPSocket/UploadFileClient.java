package JavaWeb.TCPSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class UploadFileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),6666);
        String src = "D:\\linux共享文件\\IO_files\\1.jpg";
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
             InputStream inputStream = socket.getInputStream()){
            byte[] figure = StreamUtils.streamToByteArray(bufferedInputStream);//将本地图片的数据读取并存到byte[] figure中
            bufferedOutputStream.write(figure);//将图片的数据byte[] figure发送给服务端
            socket.shutdownOutput();//设置结束标志
            byte[] receive = StreamUtils.streamToByteArray(inputStream);
            System.out.println(new String(receive));
            socket.shutdownInput();//设置结束标志

        }
    }
}
