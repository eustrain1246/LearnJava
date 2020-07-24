public class Main{
    public static void main(String[] args) {
        myInterface1 myInterface1_1 = new myRealize1();
        myInterface1_1.abstractMethod1();
        myInterface1_1.defaultMethod1();
        myInterface1 myInterface1_2 = new myRealize2();
        myInterface1_2.abstractMethod1();
        myInterface1_2.defaultMethod1();
    }
}
