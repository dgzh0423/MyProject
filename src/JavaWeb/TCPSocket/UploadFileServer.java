package JavaWeb.TCPSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class UploadFileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器在6666端口监听，等待连接...");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");
        String dest = "D:\\linux共享文件\\IO_files\\1_副本.jpg";
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
            OutputStream outputStream = socket.getOutputStream()){
            byte[] figure = StreamUtils.streamToByteArray(bufferedInputStream);//获取客户端发来的图片数据
            socket.shutdownInput();//设置结束标志
            bufferedOutputStream.write(figure);//将得到的图片数据保存到指定目录下
            outputStream.write("收到图片".getBytes(StandardCharsets.UTF_8));//向客户端发送"收到图片"的提示信息
            socket.shutdownOutput();//设置结束标志
        }
    }
}
