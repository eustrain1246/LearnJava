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
              创建一个FileOutput流，参数是String或者File对象,如果找不到路径会抛出一个异常
              在对象创建的时候，
              如果没有文件就创建文件
              第二个参数为false或者没有写第二个参数时
              如果有文件，就把之前的文件删掉，重新创建一个
              而第二个参数为true时，不会删除原文件，后面的写入操作会直接写在原数据尾部
             */
            FileOutputStream fos = new FileOutputStream(new File("Note.txt"),true);
            //向文件中写入一字节的数据，就目前的知识，如果小于0，不能确定写入了什么,大于255行为也不清楚，因为超出了一字节
            fos.write(65);// A
            //向指定的文件写入一段Byte[]数据
            fos.write("Dates 数据\n".getBytes());//换行符要注意操作系统
            //向指定的文件写入一段Byte[]数据，偏移量最小为0（不偏移），长度
            fos.write("Hello World!".getBytes(),6,5);
            //使用完后记得调用close()方法关闭此文件输入流并释放与此流有关的所有系统资源。
            fos.close();
            //close()之后不能再次写入数据
            //fos.write("Dates 数据".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
