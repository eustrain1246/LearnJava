//文件输出流
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
class Main{
    public static void main(String[] args) {
        func1();
    }
    public static void func1(){
        try {
            /*
              创建一个FileOutput流，参数是String或者File对象
              在对象创建的时候，
              如果没有文件就创建文件
              第二个参数为false或者没有写第二个参数时
              如果有文件，就把之前的文件删掉，重新创建一个
              而第二个参数为true时，不会删除原文件，后面的写入操作会直接写在原数据尾部
             */
            FileOutputStream fileOutputStream = new FileOutputStream(new File("Note.txt"),true);
            //向指定的文件写入一段Byte[]数据
            fileOutputStream.write("Dates 数据".getBytes());
            //使用完后记得调用close()方法关闭此文件输入流并释放与此流有关的所有系统资源。
            fileOutputStream.close();
            //close()之后不能再次写入数据
            //fileOutputStream.write("Dates 数据".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
