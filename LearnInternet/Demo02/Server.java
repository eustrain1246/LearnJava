import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
//客户端
public class Client {
    static final String fromAddress = "from.txt";
    static final int bufferSize = 4 * 1024;
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        Socket socket = null;
        try {
            System.out.println("Connecting...");
            //创建套接字，并连接服务器
            socket = new Socket("192.168.1.110", Server.myPort);
            System.out.print("Connect successful.");
            //根据socket获取输出流
            os = socket.getOutputStream();
            //定义文件输入流
            is = new FileInputStream(fromAddress);
            //定义缓冲区
            byte[] buffer = new byte[bufferSize];
            //读取长度
            int len = 0;
            System.out.println("Sending data.");
            //从文件读取字节数据
            while ((len = is.read(buffer)) != -1) {
                //发送给服务器
                os.write(buffer, 0, len);
                //刷新输出流
                os.flush();
            }
            //关闭输入流，并发送一个终止符给服务端
            socket.shutdownInput();
            System.out.println("Send over.");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("找不到文件");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (os != null)
                    os.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
