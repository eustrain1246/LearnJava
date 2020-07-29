import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int myPort = 23333;//指定一个接口
    public static void main(String[] args) throws IOException {
        //创建一个服务端套接字
        ServerSocket serverSocket = new ServerSocket(Server.myPort);
        System.out.println("Connecting");
        //进入监听状态，等待客户端连接，并获取与其连接的客户端的套接字
        Socket socket = serverSocket.accept();//监听，返回一个客户端的socket对象
        System.out.println("Connect successful");
        System.out.println("The port is " + socket.getPort());
        //根据套接字获取输入流
        InputStreamReader is = new InputStreamReader(socket.getInputStream());
        char[]chars = new char[1024];
        System.out.println("Reserving data from client");
        //从客户端读一段数据
        int len = is.read(chars);
        //显示在屏幕上
        if(len != -1)
            System.out.println(new String(chars,0,len) + " from client");
        else
            System.out.println("Reserved failed");
        //根据套接字获取输出流
        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
        System.out.println("Sending data to client");
        //发送给客户端
        os.write("Hello");
        os.flush();//使用Writer记得flush
        System.out.println("Send over");
        //关闭连接
        serverSocket.close();
        socket.close();
    }
}
