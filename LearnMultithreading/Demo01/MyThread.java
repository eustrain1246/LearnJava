public class MyThread extends Thread{
    @Override
    public void run() {
        //打印当前线程对象的 Id 和 Name
        System.out.println("Thread Id: " + this.getId() + " Name: " + this.getName());
        //打印当前线程Id 和 Name
        Thread thread = Thread.currentThread();     //获得运行该段代码的线程，因为run方法不一定在特定的新开辟的线程中运行
                                                    //例如可以直接通过 对象.run(); 直接调用函数
        System.out.println("CurrentThread Id: " + thread.getId() + " Name: " + thread.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run over");
    }

    public MyThread(String name) {
        super("MyThread:" + name);
    }
}
