import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//字符输入流Reader
public class Main {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader(new File("Note.txt"));//文件路径，也可以用字符串
            int a = reader.read();//读取一个字符并返回，然后迭代器后移一个字符的长度
            System.out.println((char)a);
            int b = reader.read();
            System.out.println((char)b);
            reader.skip(2);//跳过指定字符数，不能后退,如果是负数会抛出异常
            int c = reader.read();
            System.out.println((char)c);
            int d = reader.read();
            System.out.println((char)d);
            System.out.println("*************************");
            final int length = 3;//字符数组长度
            char[] e = new char[length];
            long f = reader.read(e);//读取字符数组的长度的的字符，如果文件剩余部分不够长那么会读到文件末尾，之后会返回实际读取的长度
            System.out.println(f);//打印长度
            System.out.println(e);//System.out.println可以直接打印字符数组
            System.out.println("*************************");
            char[] g = new char[99999];
            int h = reader.read(g,0,4);//offset参数指的是在数组中的偏移量，而不是在文件中的偏移量
            System.out.println(h);//打印长度
            System.out.println(new String(g,0,h));//打印内容
            //释放资源
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
