class Main{
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableInstance("Hello"));//通过实例类来生成thread对象
        thread1.start();
        //用匿名类
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is anonymous class running in thread " + Thread.currentThread().getName());
            }
        });
        thread2.start();
    }
}
