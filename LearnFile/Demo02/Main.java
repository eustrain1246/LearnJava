import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file01 = new File("Note.txt");
        if(     file01.isFile()   //是否为文件
            &&  file01.canRead()){//是否可读
            System.out.println("Load successful.");
            System.out.println("Path:\t\t\t" + file01.getPath());//路径
            System.out.println("AbsolutePath:\t" + file01.getAbsolutePath());//绝对路径
            System.out.println("Name:\t\t\t" + file01.getName());//子路径(结尾部分，也就是最后一个分隔符后面的部分)
            System.out.println("Parent:\t\t\t" + file01.getParent());//父路径
            System.out.println("Length:\t\t\t" + file01.length());//文件大小（如果是文件夹，那么返回0）
            System.out.println("Is file:\t\t" + file01.isFile());//是不是文件（其实只是检查是否能读文件）
            Scanner scanner1;
            System.out.println("File information:");
            try {
                scanner1 = new Scanner(file01);//标准输入流
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
            while(scanner1.hasNext()){
                System.out.println(scanner1.next());//以换行符、空格、制表符等结尾
            }
        }
        else{
            System.out.println("Can not load file.");
        }
        File file02 = new File("C:\\","Text.txt");
    }
}
