public interface myInterface2 {

    //抽象方法1 与myInterface1重名
    public abstract void abstractMethod1();

    //抽象方法2
    public abstract void abstractMethod2();

    //默认方法1 与myInterface1重名
    public default void defaultMethod1(){
        System.out.println("Call defaultMethod1 in myInterface.");
    }

    //默认方法2
    public default void defaultMethod2(){
        System.out.println("Call defaultMethod2 in myInterface.");
    }

}
