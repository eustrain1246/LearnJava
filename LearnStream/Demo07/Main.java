import java.io.*;
import java.nio.charset.StandardCharsets;
//字节转换流
class Main{
    public static void main(String[] args) {
        final boolean input = false;
        if (!input) {
            System.out.println("Output");
            Output();
        }
        System.out.println("Input");
        Input();
    }
    public static void Output() {
        //字符->字节
        //FileWriter在编码时只能转换为UTF-8格式
        //OutputStreamWriter可以指定目标码表
        try {
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream(new File("Note.txt"),false), //第一个参数，指定字符输出流
                    "GBK");   //第二个参数，指定编码格式，如果不写第二个参数，会用默认编码格式,
            //但是写个空字符串在这儿是不行的
            //StandardCharsets类声明了一些编码格式，可以直接拿来用
            //比如将StandardCharsets.UTF_8作为参数
            osw.write("你好，世界。");//写一段字符
            osw.close();//这个也必须要刷新，或者关闭
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void Input(){
        //字节->字符
        //FileReader在解码时只能查询IDE默认码表UTF-8
        //如果文件编码非UTF-8，就会出现乱码
        //InputStreamReader可以指定编码表
        try{
            InputStreamReader isr = new InputStreamReader(
                    new FileInputStream(new File("Note.txt")),//指定输入流
                    "GBK");     //指定编码表，如果不写，默认UTF-8
                                            //也可以用StandardCharsets类声明的编码格式
                                            //读和写的编码格式必须相同，否则会出现乱码
            //读一段字节,InputStreamReader没有readLine方法
            char[] chars = new char[128];
            int len = isr.read(chars);
            String str = new String(chars,0,len);
            System.out.println(str);
            //释放资源
            isr.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
