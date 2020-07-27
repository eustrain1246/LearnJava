import java.io.File;
//静态成员
public class Main {
    public static void main(String[] args) {
        //路径分隔符 Windows: ; Linux: :
        System.out.println(File.pathSeparator);//String
        System.out.println(File.pathSeparatorChar);//Char
        //文件名称分隔符 Windows: \ Linux: /
        System.out.println(File.separator);//String
        System.out.println(File.separatorChar);//Char

    }
}
