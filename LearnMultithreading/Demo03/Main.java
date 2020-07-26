import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//线程锁           利用 synchronized 关键字的同步方法另见 MyClass.java
class Main{
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        //这里声明一个局部类，用于下面测试
        class RunnableInstance implements Runnable {
            @Override
            public void run() {
                func1();//调用func1()方法
            }
        };
        //创建两个线程
        Thread thread1 = new Thread(new RunnableInstance());
        Thread thread2 = new Thread(new RunnableInstance());
        //开始这两个线程
        thread1.start();
        thread2.start();
    }

    static void func1(){
        lock.lock();//这里同C++一样，不做过多叙述，
        try {
            //do_something
            System.out.println("func1");
            //注意这里，如果在do_something中可能抛出异常，记得写在finally代码块内，否则会出问题
            //因为java所有的对象都存在于堆上，所以没有lock_guard这么好的东西
        }finally{
            lock.unlock();
        }
    }
}
