public class Main{
    public static void main(String[] args) {
        //Classical Method
        MyClass myClass1 = new MyClass("myClass1");
        System.out.println(myClass1.getValue());
        //通过将lambda传给一个接口生成新的对象
        func1((arg)->new MyClass(arg),"myClass2");
        //通过构造方法引用生成一个新的对象
        func1(MyClass::new,"myClass3");
    }
    public static void func1(Builder build, String arg){
        MyClass myClass = build.buildObject(arg);
        System.out.println(myClass.getValue());
    }
}
