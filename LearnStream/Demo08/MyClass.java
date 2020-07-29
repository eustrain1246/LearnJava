import java.io.Serializable;
//标记型接口，里面没有声明任何东西
//只有实现了Serializable接口的类才能进行序列化和反序列化
public class MyClass implements Serializable {
    String stringValue;
    int intValue;
    boolean booleanValue;
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
