import java.io.*;
//序列化和反序列化
//只能写非静态成员
class Main{
    public static void main(String[] args) {
        Output();
        Input();
    }
    public static void Output(){
        try {
            //创建一个对象输出流,会将对象转化成字节存储
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(
                            new File("Objects.txt"),
                            false//这里建议不写或者写false，要不然直接接在之前的文件后面可能出问题
                    )
            );//绑定一个字符输出流
            MyClass myClass01 = new MyClass("string01",1,true);
            MyClass myClass02 = new MyClass("string02",2,false);
            MyClass myClass03 = new MyClass("string03",3,true);
            MyClass myClass04 = new MyClass("string04",4,false);
            MyClass myClass05 = new MyClass("string05",5,true);
            MyClass myClass06 = new MyClass("string06",6,false);
            oos.writeObject(myClass01);
            oos.writeObject(myClass02);
            oos.writeObject(myClass03);
            oos.writeObject(myClass04);
            oos.writeObject(myClass05);
            oos.writeObject(myClass06);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void Input(){
        try{
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(new File("Objects.txt"))
            );//绑定一个字节输入流
            //默认返回一个Object类型对象，需要手动转型
            MyClass o1 = (MyClass)ois.readObject();
            MyClass o2 = (MyClass)ois.readObject();
            MyClass o3 = (MyClass)ois.readObject();
            MyClass o4 = (MyClass)ois.readObject();
            MyClass o5 = (MyClass)ois.readObject();
            MyClass o6 = (MyClass)ois.readObject();
            //因为只写入了6个对象，所以读第七个对象的时候会抛出一个文件结尾异常EOFException
            //MyClass o7 = (MyClass)ois.readObject();
            //打印输出
            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o3);
            System.out.println(o4);
            System.out.println(o5);
            System.out.println(o6);
            ois.close();//释放资源
        }
        //第二个异常类型为类找不到异常
        //1、class文件找不到
        //2、类没有继承Serializable接口
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
