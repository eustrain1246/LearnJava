//方法引用
//方法引用符 ::
public class Main extends MyClass{
    public static void main(String[] args) {
        //通过对象名引用成员方法
        MyClass o = new MyClass();
        func1(o::myPrint,"Hello");
        //通过类名引用静态成员方法
        int sum = func2(MyClass::add,2,3);
        System.out.println(sum);
        //func3中通过this引用本类成员方法
        Main main = new Main();
        int d = main.func3(5);
        System.out.println(d);
        //func5中通过super引用父类成员方法
        main.func5("world");
    }
    public int myDouble(int num){
        return num << 1;
    }
    public static void func1(MyInterface1 myInterface, String string){
        myInterface.abstractMethod(string);
    }
    public static int func2(MyInterface2 myInterface, int a, int b){
        return myInterface.add(a,b);
    }
    public int func3(int n){
        return func4(this::myDouble,n);
    }
    public int func4(MyInterface3 myInterface, int n){
        return myInterface.getDouble(n);
    }
    public void func5(String string){
        func6(super::myPrint,string);
    }
    public void func6(MyInterface1 myInterface, String string){
        myInterface.abstractMethod(string);
    }
}
