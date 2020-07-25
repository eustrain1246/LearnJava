//泛型类 意义演示
class Main{
    public static void main(String[] args) {
        Generic1 g1 = new Generic1();//如果泛型类不定义类型名称，那么泛型名称会自动变成Object
        g1.setR("String Object");//可以将一个String对象隐式转换成Object对象
        g1.setR(1);//可以将一个Integer对象隐式转换成Object对象
        Object o1 = g1.getR();//取出元素
        //如果取消下行注释，会报错，因为无法将一个Object对象隐式转换成一个String对象，Integer同理
        //String str1 = g1.getR();
        Generic1<Integer> g2 = new Generic1<Integer>();//如果指定类型名称，那么相应的泛型名称都会变成对应的类型
        //如果取消下行注释，会报错，因为无法将一个String对象隐式转换成一个Integer对象
        //g2.setR("String Object");
        g2.setR(2);//将一个Integer对象赋值给Integer，没问题
        Integer i2 = g2.getR();
        //如果取消下行注释，会报错，无法将Inter对象隐式转换成String对象
        //String str2 = g2.getR();
    }
}


