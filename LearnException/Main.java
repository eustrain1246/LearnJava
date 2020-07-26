class Main{
    public static void main(String[] args) {
        //
        try {
            //可能会出现异常的代码块
            try {
                //不会抛出异常
                System.out.println(divide(2, 3));
                //这里会抛出ArithmeticException(继承自RuntimeException)异常
                System.out.println(divide(2, 0));
                //这里会抛出自定义的MyException(继承自Exception类)异常，当然如果不将上一行注释，那么永远无法执行到这一行
                System.out.println(divide((Integer.MAX_VALUE >> 1) + 5, 0.4));
            }
            //捕捉用户自定义的异常，这个异常不是RuntimeException或RuntimeException的子类，所以必须捕捉，或者再次向上抛出
            catch (MyException myException) {
                System.out.println(myException.getMessage());
            }
            //RuntimeException或RuntimeException的子类的异常可以不处理
            //如果不处理，那么JVM将自动打印异常信息并终止程序
            /******************************************************/
            //无论是否出现异常、是否捕捉都会执行该代码块，适合做一些收尾工作
            //如上面的就没有ArithmeticException异常Catch，但是仍会看到后面打印的Catch over
            finally {
                System.out.println("Catch over");
            }
        }
        finally {//多层嵌套的finally代码块也会执行
            System.out.println("Catch over again");
        }
    }
    //一个可能抛出异常的类
    static double divide(double a, double b) throws MyException, ArithmeticException {//该方法不处理指定的异常，而是直接将异常抛出,而且异常不限于一个
        if(b == 0)
            throw(new ArithmeticException("The dividend is 0."));
        if(b < 1 && b > -1 && a >= Integer.MAX_VALUE >> 1)
            throw(new MyException("Unsafe value", a));
        return a / b;
    }
}
