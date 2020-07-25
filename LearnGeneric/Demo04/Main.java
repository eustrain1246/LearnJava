//泛型通配符 ? <-英文的半角问号
import java.util.ArrayList;
class Main{
    public static void main(String[] args) {
        DemoClass1.func_s1("String Object");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("string1");
        strings.add("string2");
        strings.add("string3");
        DemoClass1.func_s2(strings);
        //DemoClass1.func_s3("String Object"); //Undefined
        //错误 Object类不是Number的子类
        //DemoClass1.func_s4(new ArrayList<Object>());
        //正确 Integer是Number类的子类
        DemoClass1.func_s4(new ArrayList<Integer>());
        //正确，Object类是Number类的父类
        DemoClass1.func_s5(new ArrayList<Object>()) ;
        //错误，Integer类不是Number类的父类
        //DemoClass1.func_s5(new ArrayList<Integer>());
    }
}
