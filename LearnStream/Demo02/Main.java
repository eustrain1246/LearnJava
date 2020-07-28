import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//文件字节输入流
public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(new File("Note.txt"));
            //读一个字节作为返回值，然后迭代器后移一位，如果迭代器移至文件末尾，那么返回-1，不抛出异常
            int a = fis.read();
            System.out.println(a);
            int b = fis.read();
            System.out.println(b);
            int c = fis.read();
            System.out.println(c);
            //将迭代器向后跳一定长度，并返回跳跃的距离（并不是实际跳了多远，只是将参数返回而已）
            //如果参数是负数，那么会尝试向后（与read反向）跳，但是如果跳到了文件开头之前会抛出一个IOException
            //如果向前（与read同向）跳过了，不会抛出异常，会跳到文件尾EOF处
            long d = fis.skip(-3);//这里刚好跳到了文件开始处
            System.out.println(d);
            int e = fis.read();//这里会和a的值相同
            System.out.println(e);
            long f = fis.skip(-1);
            System.out.println(f);
            int g;
            while((g = fis.read()) != -1)
                System.out.print((char)g);//这里是不能正常显示中文的，因为将一字节当成2字节显示了
            System.out.println();
            try {//跳到开头
                while(true) fis.skip(-1);//通过抛出异常来跳出循环。。。。（奇妙的操作）
            }
            catch (IOException ioe){
                System.out.println("removed the file's begin");
            }
            int h = fis.read();//将会和a、e相同
            System.out.println(h);
            fis.skip(-1);//再次跳到开头
            final int length = 5;//长度
            byte[] i = new byte[length];//这里不能是空指针，否则会抛出一个空指针异常
            //读取byte数组长度的字节存在改byte中,并返回读取的字节数，如果到头了会返回一个-1。注该函数并不会申请空间
            fis.read(i);//注意这里是覆盖读取，如果读的长度不够byte数组的长度，剩下的数据不会被初始化为0，会保持原来的数据
            System.out.println(i);//System.out.println不能打印字符数组
            System.out.println(new String(i));//应转为String对象,再打印输出，这里能够正常显示中文
            byte[] j = new byte[99999];
            int k = fis.read(j);
            System.out.println(k);//read函数如果读的长度大于剩余长度，也会正常读取并返回正常读取的字节数
            System.out.println(new String(j));
            fis.skip(-1 * (length + k));//再次回到开头
            //释放资源，当然之后也不能再次read或者skip
            fis.close();
            //其实用Scanner也可以读文件，就是在构造的时候传File对象就好了，我记得在以前的某个例子里面用的就是Scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
