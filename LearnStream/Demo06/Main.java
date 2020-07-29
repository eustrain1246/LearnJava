import java.io.*;
//缓冲流
class Main{
    public static void main(String[] args) {
        try {
            //缓冲流使用时的速度较快于无缓冲版本
            //以下四种缓冲流都有第二个参数size，用于指定缓冲区大小，如果不写会使用默认缓冲区大小
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("Note.txt")));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("Note.txt")));
            BufferedReader br = new BufferedReader(new FileReader(new File("Note.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Note.txt")));
            //BufferedInputStream和BufferedOutputStream与InputStream和OutputStream在使用上区别不大
            //BufferedReader和BufferedWriter主要添加了两个函数
            //读一行
            br.readLine();//不包含终止符“换行符”
            //写一个换行符
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
