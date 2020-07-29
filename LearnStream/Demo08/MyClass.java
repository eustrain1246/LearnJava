import java.io.Serializable;
//标记型接口，里面没有声明任何东西
//只有实现了Serializable接口的类才能进行序列化和反序列化
public class MyClass implements Serializable {
    String stringValue;
    int intValue;
    boolean booleanValue;
    //如果类发生改变，那么会重新生成一个新的序列号，当读取的时候根据文件中的序列号将找不到对应的class文件
    //抛出一个序列号冲突的异常
    //可以声明一个静态 long 类型常量 （可以是私有的）自定义类的序列号
    static final long serialVersionUID = 42L;//声明一个唯一序列号
    public MyClass(String stringValue, int intValue, boolean booleanValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", booleanValue=" + booleanValue +
                '}';
    }
}
