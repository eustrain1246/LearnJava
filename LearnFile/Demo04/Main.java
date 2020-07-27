import java.io.File;
//遍历指定路径下的文件/文件夹
class Main{
    public static void main(String[] args) {
        func1();
    }
    public static void func1(){
        File file = new File("." + File.separator);//打印当前目录，如果没有.就打印C:\
        //打印出指定路径下的所有文件和文件夹(包括被隐藏的文件或文件夹)
        String[] list = file.list();//如果路径不存在，或者File对象存储的是一个文件，那么会抛出空指针异常
        for(String string : list)//指定路径下的所有文件和文件夹的名字
            System.out.println(string);
        System.out.println("**********************************************");
        File[] files = file.listFiles();//这个和list很像,但是这个直接搞成整个路径，不光有名字
        for(File f : files)
            System.out.println(f);
    }
}
