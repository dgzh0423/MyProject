package JavaWeb.UDP;

import java.io.IOException;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        try(DatagramSocket datagramSocket = new DatagramSocket(9999)) {
            String data = UDPUtils.ByteArrayToString(datagramSocket);
            System.out.println(data);

            byte[] info = "hello Jerry".getBytes(StandardCharsets.UTF_8);
            UDPUtils.SendByteArray(datagramSocket, info,9998);
        }
    }
}
