package JavaWeb;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAddressClass {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //通过InetAddress对象获取ip地址
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);

        //根据域名获取InetAddress对象，比如www.baidu.com
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
    }
}
