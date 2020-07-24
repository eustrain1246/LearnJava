public class myRealize1 implements myInterface{

    //对抽象方法的实现
    @Override
    public void abstractMethod1() {
        System.out.println("Call abstractMethod1 in myRealize1");
    }

    //重写默认方法
    @Override
    public void defaultMethod1() {
        System.out.println("Call defaultMethod1 in myRealize1.");
    }

//    @Override //静态方法无法重写
//    public static void staticMethod1(){
//        System.out.println("Call staticMethod1 in myInterface.");
//    }


//    @Override //私有方法无法重写
//    private void privateMethod(){
//
//    }

//    @Override //私有方法无法重写
//    private void privateMethod1(){
//        System.out.println("Call privateMethod1 in myInterface");
//    }

//    @Override //私有静态方法无法重写
//    private static void privateStaticMethod1(){
//        System.out.println("Call privateStaticMethod1 in myInterface");
//    }


}
