package JavaWeb.TCPSocket;

import java.io.*;

public class StreamUtils {
    //读取文件内容并存到byte[]result中
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            byte[] result = baos.toByteArray();
            return result;
        }
    }
}
