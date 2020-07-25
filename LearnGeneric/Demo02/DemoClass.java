public class DemoClass {

    public <E> void func1(E e){//顺序不能改
        System.out.println("func1:\t" + e);
    }
    //
    public <E> void func2(){//如果无法通过参数对类型进行判断，那么就是Object类型,并没有什么意义
        E a = (E)new Object();//申请一个对象，防止下一行出现空指针异常
        System.out.println("func2:\t" + a);//此处打印输出"java.lang.Object@地址"
    }
    public <E,S> void func3(E e, S s){//可以有多个参数
        System.out.println("func3:\t" + e);
        System.out.println(s);
    }
    public static <R> R func_s(R r){//静态函数也可以是泛型的
        System.out.println("func_s return:" + r);
        return r;
    }
    /* 代码块是不行的
    static <E>{
        
    }
    */
}
