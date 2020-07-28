import java.io.*;
import java.util.Scanner;
//JDK7和JDK9中的新特性
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                int num = scanner.nextInt();
                if (num == 7) {
                    JDK7();
                    break;
                }
                else if (num == 9) {
                    JDK9();
                    break;
                }
                else
                    System.out.println("Please input number 7 or 9");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } while (true);
    }
    public  static void JDK7(){
        try(
                //在这里声明的流对象会在结束时自动close,多个语句用;隔开
                FileWriter fw = new FileWriter("Note.txt",true);
                FileReader fr = new FileReader("Note.txt");
        ) {
            //do_something
            char[] chars = new char[10];
            System.out.println(fr.read(chars));
            System.out.println(chars);
            fw.write(chars);
            //这里将自动调用close，不需要finally代码块
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public  static void JDK9() {
        try {//这个try是为了解决new的时候抛出的异常
            FileOutputStream fos = new FileOutputStream("Note.txt", true);
            FileInputStream fis = new FileInputStream("Note.txt");
            //try-with-resources要求括号里面的对象必须是final或者可以被推断为final的，如果取消下行注释，将会弹出error
            //fis = null;
            try (fos;fis) {//其实就是给JDK7的部分又修改了以下
                //do_something
                byte[] bytes = new byte[10];
                System.out.println(fis.read(bytes));
                System.out.println(new String(bytes));
                fos.write(bytes);
                //这里将自动调用close，不需要finally代码块
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
