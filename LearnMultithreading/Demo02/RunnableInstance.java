public class RunnableInstance implements Runnable {
    //可以通过实现一个Runnable（不是Runable）实例类来构造对象作为Thread类的参数
    //要求实现run()，然后Thread类的run方法将会执行Runnable实例类的run方法
    @Override
    public void run() {
        System.out.println("Print: " + s + "\t at Thread:" + Thread.currentThread().getName());
    }
    private String s;
    public RunnableInstance(String s){
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }
    public String getS() {
        return s;
    }
}
