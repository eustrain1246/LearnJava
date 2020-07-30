public abstract class myAbstractRealize1 implements myInterface2 {
    //抽象类可以不实现接口中的函数，交给抽象类的实现类进行实现
    //比如这里只实现了 abstractMethod1 ，但是没实现 abstractMethod2 ，也没报错

    @Override
    public void abstractMethod1() {
        System.out.println("Call abstractMethod1 in myAbstractRealize1.");
    }
}
