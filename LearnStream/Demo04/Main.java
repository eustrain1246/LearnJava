import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//字符输出流
public class Main{
    public static void main(String[] args) {
        try {
            //File对象的位置可以直接用String对象替代，
            //如果后面append参数为false或者没有写append参数（也就是只有File或String一个参数）
            //那么在创建对象的时候如果有原文件就会删除原文件，新建一个空的文件
            //如果append参数为true，不会删除原文件，并且write操作会在追加在文件原内容的后面
            //若找不到文件，或者是个文件夹，会抛出一个IOException异常
            FileWriter fileWriter = new FileWriter(new File("Note.txt"),false);
            //write写字符串(String对象)
            fileWriter.write("Hello ");
            //不同于FileOutputStream
            //对于FileWriter,如果不刷新，那么并不会将内容写到磁盘中，只会留在缓冲区里
            fileWriter.flush();
            //append写字符串
            fileWriter.append("World\n");
            //append和write区别：
            //如果传进去的参数为空（null）write会抛出一个空指针异常，而append会把"null"作为字符串写进去
            //append方法实际上就是对write封装了一层实现Appendable接口而已,后面将不再完全相同的append方法
            //写一个字符，参数：整数
            fileWriter.write(42);//字符: *
            //同上，write方法并没有char参数的方法，下面语句只是将char再次转型成了int类型而已
            fileWriter.write((char) 65);//字符: A
            //但是append有将char作为参数的重载,同样是在调用write
            fileWriter.append((char)66);//字符: B
            //字符数组
            char[] chars = {'字','符','输','入','流'};
            //将字符数组作为参数
            fileWriter.write(chars);
            //字符数组和String都有带偏移量和长度的版本，这里只写String的版本
            fileWriter.write("chars",2,3);//写ars
            //刷新并释放资源
            fileWriter.close();
            //如果要保证写到文件，建议把close放到finally块中，由于close也会抛出异常，所以还需要在finally中再套一层try-catch
            //而且不能保证写到文件里的信息完整，因为异常机制将异常抛出之后的代码跳过了
            //JDK7 和 JDK9的新特性见下一个Demo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
