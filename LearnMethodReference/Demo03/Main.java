public class Main{
    public static void main(String[] args) {
        int len = 10;
        //传统方法创建数组
        MyClass[] arr1 = new MyClass[len];
        System.out.println(arr1.length);
        //使用接口，并传递lambda表达式创建数组
        func1(length->new MyClass[length],len);
        //使用数组构造器引用
        func1(MyClass[]::new,len);
    }
    public static void func1(ArrayBuilder builder, int len){
        MyClass[] arr = builder.build(len);
        System.out.println(arr.length);
    }
}
