import java.io.File;
import java.io.IOException;
//文件/文件夹的创建和删除操作
public class Main {
    public static void main(String[] args) {
        createFile();
    }
    //创建文件
    public static void createFile() {
        //构造一个File对象
        File file = new File("C:" + File.separatorChar + "Note" + File.separatorChar + "c.txt");
        try {
            //根据路径创建文件
            //createNewFile方法不能创建文件夹
            if(file.createNewFile()){//如果返回True说明指定路径下没有指定文件
                System.out.println("Create Successful");
            }
            else{//如果返回false说明文件已经存在，不会创建文件
                System.out.println("There been a file");
            }
        } catch (IOException e) {//如果目录不存在，会抛出一个异常
            System.out.println("Path doesn't exist");
            //e.printStackTrace();
        }
    }
    //创建文件夹
    public static void makefolder{
        //构造一个File对象
        File file = new File("C:" + File.separatorChar + "Note");
        //下面讲个方法只能创建文件夹，不能创建文件
        //mkdir只能创建单级文件夹
        System.out.println(file.mkdir());//如果文件夹不存在那么返回true，否则返回false，如果将要创建的文件夹所在路径不存在也返回false
        //mkdirs可以创建多级文件夹
        System.out.println(file.mkdirs());//如果文件夹不存在那么返回true，否则返回false
        //其实就是如果创建成功就返回true，失败就返回false
    }
    //删除文件夹或文件
    public static void delete{
        //构造一个File对象，指向一个文件
        File file = new File("C:" + File.separatorChar + "Note" + File.separatorChar + "c.txt");
        System.out.println(file.delete());//如果文件存在，那么删除文件，返回删除文件是否成功，否则返回false

        //构造一个File对象，指向一个文件夹
        File folder = new File("C:" + File.separatorChar + "Note");//如果文件夹存在，且为空文件夹，那么删除文件夹返回删除是否成功，否则返回false
        System.out.println(folder.delete());
    }
}
