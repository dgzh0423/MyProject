package JavaWeb.TCPSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {
    public static void main(String[] args) throws IOException {

        //1.在本机9999端口监听，等待连接(前提9999端口是可用的)
        try(ServerSocket serverSocket = new ServerSocket(9999)){
            //2.当没有客户端连接9999端口时，程序会阻塞，等待连接
            //有客户端连接就会返回一个Socket对象
            try(Socket socket = serverSocket.accept()){
                try(InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream()) {
                    //3.1获取客户端发送过来的数据
                    byte[] buffer = new byte[1024];
                    int n;
                    while ((n = inputStream.read(buffer)) != -1) {
                        System.out.println(new String(buffer, 0, n));
                    }
                    socket.shutdownInput();//设置结束标记
                    //3.2发送给客户端信息
                    outputStream.write("hello, client".getBytes(StandardCharsets.UTF_8));
                    socket.shutdownOutput();//设置结束标记
                }
            }
        }
        /*
        4.关闭输入流和socket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        */
    }
}
