package JavaWeb.UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket(9998)) {
            byte[] data = "hello Tom".getBytes(StandardCharsets.UTF_8);
            UDPUtils.SendByteArray(datagramSocket, data, 9999);

            String info = UDPUtils.ByteArrayToString(datagramSocket);
            System.out.println(info);
        }
    }
}
