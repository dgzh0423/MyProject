package JavaWeb.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPUtils {
    //发送数据byte[]
    public static void SendByteArray(DatagramSocket ds, byte[] data, int port) throws IOException {
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), port);
        System.out.println("开始发送");
        ds.send(datagramPacket);
    }

    //将接收的数据byte[]转为String
    public static String ByteArrayToString(DatagramSocket ds) throws IOException {
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        System.out.println("等待接收...");
        ds.receive(datagramPacket);//接收数据
        int length = datagramPacket.getLength();//接收数据的实际长度
        byte[] data = datagramPacket.getData();//接收的实际数据
        return new String(data, 0, length);
    }
}
