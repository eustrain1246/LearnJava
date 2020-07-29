import java.io.*;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Connecting");
        //创建一个套接字，用于连接服务端，如果无法连接服务端会抛出一个java.net.ConnectException异常，所以必须先启动服务端
        Socket socket = new Socket("127.0.0.1",Server.myPort);
        System.out.println("Connect successful");
        System.out.println("The port is " + socket.getPort());
        //根据套接字获取输出流
        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
        System.out.println("Sending data to Server");
        //向服务端发送一段数据
        os.write("Hello");
        os.flush();
        System.out.println("Send over");
        //根据套接字获取输入流
        InputStreamReader is = new InputStreamReader(socket.getInputStream());
        char[] chars = new char[1024];
        System.out.println(socket.getKeepAlive());
        System.out.println("Reserving data from server");
        //从服务端获取一段数据
        int len = is.read(chars);
        //并显示到屏幕上
        if(len != -1)
            System.out.println(new String(chars,0,len) + " from Server");
        else
            System.out.println("Reserved failed");
        //关闭连接
        socket.close();
    }
}
