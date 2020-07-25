import java.util.ArrayList;
public class DemoClass{
    public static <E> void func_s1(E e){//这里是一个静态的泛型函数，是不是静态无所谓
        System.out.println("func_s1" + e);
    }
    //这里传的是一个ArrayList对象，但是类型却并不重要，所以可以直接用？代替
    public static void func_s2(ArrayList<?> listEObjects){
        System.out.println("func_s2" + listEObjects);
    }
    //这样是不对的
    /*
    public static void func_s3(? e){
        System.out.println("func_s3" + e);
    }
    */
    //以下部分实际应用不多
    //和func_s2有点不一样
    //这里限定了泛型的特点,这里必须是Number或Number的子类
    public static <E> void func_s4(ArrayList<? extends Number> listEObjects){
        System.out.println("func_s4" + listEObjects);
    }
    //这里必须是Number或者Number的父类（超类）
    public static <E> void func_s5(ArrayList<? super Number> listEObjects){
        System.out.println("func_s5" + listEObjects);
    }
}
