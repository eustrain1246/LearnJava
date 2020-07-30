public interface myInterface1 {
    /**接口中可以包含的内容：
     *java7：
     常量
     抽象方法
     *java8：
     默认方法
     静态方法
     *java9
     私有方法
     */
//Java7

    //常量
    //常量不能修改，而且必须再声明处赋初值
    //public 关键字、static 关键字和 final 关键字可以省略，
    //但是必须是public static final 暂不支持私有常量
    public static final int constNum = 42;//整数常量
    class C{}
    public static final C constC = new C();//引用常量
    //public static final C tc;//错误用法

    //接口的抽象方法不做具体实现(且不可实现)，完全交给实现类（且必须实现）
    //public 关键字和 abstract 关键字可以省略, 但是必须是public 和 abstract
    public abstract void abstractMethod1();

//Java8
    //实现类可以不实现接口的默认方法，实现类可以重写（override）默认方法
    //default 关键字不可省略， public 关键字可以省略， 但是必须是 public
    public default void defaultMethod1(){
        System.out.println("Call defaultMethod1 in myInterface.");
    }

    //静态方法仅属于接口本身，无法被实现类重写，无法用 对象.静态方法(参数); 的方式调用
    //应该使用 接口名.静态方法(参数); 的方式调用静态方法
    //static 关键字不可省略， public 关键字可以省略， 但是必须是 public
    public static void staticMethod1(){
        System.out.println("Call staticMethod1 in myInterface.");
    }

//Java9
    //实现类不能看到私有方法，也不能重写私有方法
    //私有方法可以被其他的非静态（抽象）方法调用，也可以调用其他的方法（不限于非静态方法）
    //private 关键字不可省略
    private void privateMethod1(){
        System.out.println("Call privateMethod1 in myInterface.");
    }

    //实现类也看不到私有静态方法
    //私有静态方法可以被接口内的其他方法调用， 也可以调用接口内的其他静态方法（私有或共有）
    //private 关键字和 static 关键字不可省略
    static void privateStaticMethod1(){
        System.out.println("Call privateStaticMethod1 in myInterface.");
    }

}
