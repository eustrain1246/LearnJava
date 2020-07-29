import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//打印流
class Main{
    public static void main(String[] args) throws IOException {
        //System.out就是一个打印流对象
        System.out.println("System.out is a PrintStream object.");
        //创建一个打印流
        /*
        参数：
        1、OutputStream对象
        2、OutputStream对象、boolean autoFlush 是否自动刷新
        3、与2反过来
        4、String fileName 文件路径
        5、String fileName、Charset charset 编码格式
        6、File file 文件
        7、File file String csn 编码格式 调用了构造函数8
        8、File file Charset charset 编码格式
         */
        PrintStream ps = new PrintStream(new FileOutputStream(new File("Note.txt"),false));
        ps.println(97);//如果用print或println打印数字，将打印数字相应的字符串，而不是对应的字符
        //重定向System.out
        System.setOut(ps);
        //打印到文件
        System.out.println("Printed to Note.txt");
    }
}
