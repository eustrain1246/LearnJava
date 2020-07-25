//泛型函数
class Main{
    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();
        demoClass.func1("String Object");
        demoClass.func2();
        demoClass.func3("String Object", 2);
        System.out.println(DemoClass.func_s("String Object"));
    }
}


