package JavaWeb.TCPSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.连接服务端（ip,端口）连接成功，返回Socket对象
        try(Socket socket = new Socket(InetAddress.getLocalHost(), 9999)){
            //2.通过socket.getOutputStream()得到和socket关联的输出流对象
            try(OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream()) {
                //3.1通过输出流将数据传给服务端
                outputStream.write("hello, server".getBytes(StandardCharsets.UTF_8));
                socket.shutdownOutput();//设置结束标记
                //3.2读取服务端发送来的数据
                byte[] buffer = new byte[1024];
                int n;
                while ((n = inputStream.read(buffer)) != -1) {
                    System.out.println(new String(buffer, 0, n));
                }
                socket.shutdownInput();//设置结束标记
            }
        }
        /*
        4.关闭输出流和socket
        outputStream.close();
        inputStream.close();
        socket.close();
        */
    }
}
