public class myRealize2 implements myInterface1, myInterface2 {

//重名的方法只写一次即可
    @Override
    public void abstractMethod1() {
        System.out.println("Call abstractMethod1 in myRealize2.");
    }

//冲突的默认方法必须重写
    @Override
    public void defaultMethod1() {
        System.out.println("Call defaultMethod1 in myRealize2.");
    }

//接口的抽象方法必须实现
    @Override
    public void abstractMethod2() {
        System.out.println("Call abstractMethod2 in myRealize2.");
    }

//接口的默认方法可以不实现
//    @Override
//    public void defaultMethod2() {
//        System.out.println("Call defaultMethod2 in myRealize2.");
//    }

    /**以下不进行演示：
     * 如果接口的默认方法和父类的方法冲突，调用时默认调用父类的方法
     * 接口之间可以继承，甚至可以多继承
     * 如果多继承时，两个接口的默认方法冲突，解决方法同一般的类相同，必须进行重写（default关键字不能省略）
     */



}
