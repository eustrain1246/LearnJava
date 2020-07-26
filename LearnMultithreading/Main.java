class Main{
    public static void main(String[] args) {
        Demo();
    }
    public static void Demo(){
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();
        //直接调用run方法
        myThread1.run();
        myThread2.run();
        myThread3.run();
        myThread4.run();
        System.out.println("*********************");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        //Thread对象不能重复start，如果取消下行注释，那么会抛出一个异常
        //myThread1.start();
        System.out.println("*********************");
        try {
            myThread1.join();
            myThread1.join();
            myThread1.join();
            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        对上面捕获的异常的解释 具体见 https://www.ibm.com/developerworks/cn/java/j-jtp05236.html
        Thread.sleep()、 Thread.join() 或 Object.wait()被称为阻塞方法
        当另一个线程通过调用 Thread.interrupt() 中断一个线程时，会出现以下两种情况之一。如果那个线程在执行一个低级可中断阻塞方法
        那么它将取消阻塞并抛出 InterruptedException。否则， interrupt() 只是设置线程的中断状态。
        在被中断线程中运行的代码以后可以轮询中断状态，看看它是否被请求停止正在做的事情。中断状态可以通过 Thread.isInterrupted() 来读取，
        并且可以通过一个名为 Thread.interrupted() 的操作读取和清除。
         */
    }
}
