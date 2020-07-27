import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

//查找指定路径下的文件/文件夹
//只能查找一级，不支持多级查找
class Main{
    public static void main(String[] args) {
        func1();
    }
    public static void func1(){
        //文件过滤器
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {//过滤掉使accept函数返回false的文件名
                return pathname.getName().contains("e");
            }
        };
        File file = new File("." + File.separatorChar);
        for(File f : file.listFiles(fileFilter))//只输出满足条件的文件/文件夹
            System.out.println(f);
    }
    //FileNameFilter和FileFilter相似
    FilenameFilter filenameFilter = new FilenameFilter() {
        @Override
        public boolean accept(  File dir        // 根目录
                                , String name   // 文件/文件夹的名称
        ) {
            return new File(dir,name).isDirectory() || name.contains("s");
        }
    };
}
