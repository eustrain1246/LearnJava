import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//从客户端向服务端发送数据
public class Server{
    static final int myPort = 62557;
    static final String toAddress = "to.txt";
    static final int bufferSize = 4 * 1024;
    public static void main(String[] args) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            //创建文件输出流，指向toAddress文件
            os = new FileOutputStream(toAddress,false);
            //建立一个服务器套接字
            ServerSocket serverSocket = new ServerSocket(myPort);
            System.out.println("Connecting...");
            //监听，获取客户端的套接字
            Socket socket = serverSocket.accept();
            //打印输出客户端IP地址
            System.out.print("Connect successful.");
            System.out.println("\tIp is " + socket.getInetAddress());
            //获取输出流
            is = socket.getInputStream();
            //声明缓冲区
            byte[] buffer = new byte[bufferSize];
            //保存数据的大小
            int len = 0;
            System.out.println("Reserving data.");
            //每次从服务端读bufferSize字节的数据
            //有必要对available进行判断，因为最后一次读数据之后流可能就关闭了，
            //在流关闭后再直接读数据会抛出SocketException: Connection reset异常，而不是返回-1
            while (is.available() != 0 && (len = is.read(buffer)) != -1) {
                //写到文件
                os.write(buffer, 0, len);
                //刷新输出流
                os.flush();
            }
            System.out.println("Reserve over.");
            Thread.sleep(3000);
        }
        catch(IOException | InterruptedException e){
            e.printStackTrace();
        } finally {
            try {
                if(is != null)
                    is.close();
                if(os != null)
                    os.close();
            }
            catch(NullPointerException e){
                e.printStackTrace();
            }
        }
    }
}
