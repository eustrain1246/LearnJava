import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//synchronized 关键字的使用
public class MyClass {
    Object mutex;
    public void func_in() {//直接使用锁对象
        //do_something
        //这里编译器提示"在非 final 字段 'mutex' 上同步"说明如果该函数被重写了，那么就不会用到这个锁了，也就有可能不安全了
        synchronized (mutex) {//这里使用this作为锁对象，锁对象可以是任意类型，锁定在传进去的锁对象的级别
            //do_something_safely
        }
        //do_other_something
    }
    //以下两种方式，都是通过锁对象实现的，一个是this，一个是类名.class 这也是一个对象
    public synchronized void func_syn(){//同步方法，锁定在对象级别

    }
    public static synchronized void func_syn_s(){//静态同步方法，锁定在类级别

    }

}
