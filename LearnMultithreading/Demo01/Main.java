class Main{
    public static void main(String[] args) {
        Demo();
    }
    public static void Demo(){
        MyThread myThread1 = new MyThread("1");
        MyThread myThread2 = new MyThread("2");
        MyThread myThread3 = new MyThread("3");
        MyThread myThread4 = new MyThread("4");
        //直接调用run方法
        myThread1.run();
        myThread2.run();
        myThread3.run();
        myThread4.run();
        System.out.println("*********************");
        try {
            Thread.sleep(500);//暂停执行该语句的线程500毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建一个新的线程，然后在新的线程上运行run()方法
        //相关资料 https://www.cnblogs.com/renhui/p/6066750.html
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        //Thread对象不能重复start，如果取消下行注释，那么会抛出一个异常
        //myThread1.start();
        System.out.println("*********************");
        try {//如果函数需要指定线程运行结束，那么需要join函数等待线程运行结束
             //否则不写join也没问题
             //主线程会等所有线程运行结束的（自检没问题，但未找到相关资料）
            myThread1.join();
            myThread2.join();
            myThread3.join();
            myThread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("函数结束");
        /*
        对上面捕获的异常的解释 相关资料 https://www.ibm.com/developerworks/cn/java/j-jtp05236.html
        Thread.sleep()、 Thread.join() 或 Object.wait()被称为阻塞方法
        当另一个线程通过调用 Thread.interrupt() 中断一个线程时，会出现以下两种情况之一。如果那个线程在执行一个低级可中断阻塞方法
        那么它将取消阻塞并抛出 InterruptedException。否则， interrupt() 只是设置线程的中断状态。
        在被中断线程中运行的代码以后可以轮询中断状态，看看它是否被请求停止正在做的事情。中断状态可以通过 Thread.isInterrupted() 来读取，
        并且可以通过一个名为 Thread.interrupted() 的操作读取和清除。
         */
    }
}
