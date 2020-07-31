import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射 reflect
public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, InstantiationException {
        GetClass();
        System.out.println("===========================================");
        CompareClass();
        System.out.println("===========================================");
        GetField();
        System.out.println("===========================================");
        GetMethod();
        System.out.println("===========================================");
        GetConstructor();
        //System.out.println("===========================================");
    }
    public static void GetClass() throws ClassNotFoundException{
        //获取类对象的三种方式
        //方式1 Class.forName("完整类名")
        Class<?> myClass1 =  Class.forName("package1.MyClass");//可能会抛出类找不到异常
        System.out.println(myClass1.getName());
        //方式2 类名.class
        Class myClass2 = MyClass.class;
        System.out.println(myClass2.descriptorString());
        //方式3 对象名.getClass()
        MyClass obj = new MyClass();
        Class<?> myClass3 = obj.getClass();
        System.out.println(myClass3.getPackageName());
        //获取泛型类的类对象，不能加上<泛型>
        //Class<?> myClass4 = Class.forName("package1.Generic1<String>");//找不到类
        Class<?> myClass4 = Class.forName("package1.Generic1");
        //Class<?> myClass5 = Class.forName("package1.Generic2<String>");//找不到类
        Class<?> myClass5 = Class.forName("package1.Generic2");
        System.out.println(myClass4 == myClass5);//false
        System.out.println(myClass4.equals(myClass5));//false
    }
    public static void CompareClass() throws ClassNotFoundException, NoSuchFieldException {
        //包package1下的MyClass类
        Class<?> myClass1 =  Class.forName("package1.MyClass");
        //默认包下的MyClass类，通过.class获取
        Class myClass2 = MyClass.class;
        //默认包下的MyClass类，通过对象获取
        MyClass obj = new MyClass();
        Class<?> myClass3 = obj.getClass();
        //在程序运行过程中，每个类的字节码文件有且只有一个
        System.out.println(myClass1 == myClass2);//false
        System.out.println(myClass2 == myClass3);//true
        /////////////////////////////////////////////////////////////
        //Class<?> myClass4 = Class.forName("package1.Generic1<String>");//找不到类
        Class<?> myClass4 = Class.forName("package1.Generic1");
        //Class<?> myClass5 = Class.forName("package1.Generic2<String>");//找不到类
        Class<?> myClass5 = Class.forName("package1.Generic2");
        System.out.println(myClass4 == myClass5);//false
        System.out.println(myClass4.equals(myClass5));//false
        //获取同一个类的两个不同的泛型
        package1.Generic1<String> myClass6 = new package1.Generic1<String>();
        package1.Generic1<Integer> myClass7 = new package1.Generic1<Integer>();
        System.out.println(myClass6.getClass() == myClass7.getClass());//true
        System.out.println(myClass6.getClass().equals(myClass7.getClass()));//true
        //上面充分说明了Java的泛型是通过类型擦除实现的
    }
    /*  get方法
    获取成员变量
    ** 获取public成员变量
    public Field getField(String name) throws NoSuchFieldException, SecurityException
    Field[] getFields() throws SecurityException
    Field getDeclaredField(String name) throws NoSuchFieldException, SecurityException
    Field[] getDeclaredFields() throws SecurityException
    获取成员方法
    Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
    Method[] getMethods() throws SecurityException
    Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
    Method[] getDeclaredMethods() throws SecurityException
    获取构造器
    Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
    Constructor<?>[] getConstructors() throws SecurityException
    Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
    Constructor<?>[] getDeclaredConstructors() throws SecurityException
    //获取类名
    String getName()
    String getSimpleName()
    String getTypeName()
    String getCanonicalName()
    //获取包名
    String getPackageName()
    //获取包
    Package getPackage()
    //获取实现的接口
    Class<?>[] getInterfaces()
    //获取父类
    Class<? super T> getSuperclass()
    //获取带泛型的父类
    Type getGenericSuperclass()
     */
    //获取成员变量
    public static void GetField() throws NoSuchFieldException, IllegalAccessException {
        Class<MyClass> myClass = MyClass.class;
        //只能获取public成员变量
        //getField
        Field field = myClass.getField("publicField");
        System.out.println(field);//打印输出
        //getFields
        Field[] fields = myClass.getFields();
        System.out.print("[");//打印输出
        for(Field f : fields)
            System.out.print(f + ",");
        System.out.println("\b]");
        //[public java.lang.String MyClass.publicField]
        //获取所有的成员变量
        //getDeclaredField
        Field declaredFiled1 = myClass.getDeclaredField("publicField");
        Field declaredFiled2 = myClass.getDeclaredField("DefaultField");
        Field declaredFiled3 = myClass.getDeclaredField("ProtectedField");
        Field declaredFiled4 = myClass.getDeclaredField("PrivateFiled");
        System.out.println(declaredFiled1);//public java.lang.String MyClass.publicField
        System.out.println(declaredFiled2);//java.lang.String MyClass.DefaultField
        System.out.println(declaredFiled3);//protected java.lang.String MyClass.ProtectedField
        System.out.println(declaredFiled4);//private java.lang.String MyClass.PrivateFiled
        //getDeclaredFields
        Field[] declaredFields = myClass.getDeclaredFields();
        System.out.print("[");//打印输出
        for(Field f : declaredFields)
            System.out.print(f + ",");
        System.out.println("\b]");
//[public java.lang.String MyClass.publicField,java.lang.String MyClass.DefaultField,//这里切断一下，太长了
//protected java.lang.String MyClass.ProtectedField,private java.lang.String MyClass.PrivateFiled]
        //使用Field
        //get 和 set方法存在异常:
        // IllegalArgumentException 类型不对
        // IllegalAccessException   没有访问权限
        MyClass myClass1 = new MyClass();
        System.out.println(field.get(myClass1));//null
        myClass1.setPublicField("_P_u_b_l_i_c_");
        System.out.println(field.get(myClass1));//_P_u_b_l_i_c_
        field.set(myClass1,"Field_Set");
        System.out.println(myClass1.getPublicField());//Field_Set
        //没有访问权限 抛出 IllegalAccessException 异常
        //System.out.println(declaredFiled4.get(myClass1));
        declaredFiled4.setAccessible(true);//修改访问权限，暴力反射
        System.out.println(declaredFiled4.get(myClass1));//null
        //就算修改了访问权限，直接修改操作，编译期也无法通过
        //System.out.println(myClass1.PrivatedField);
    }
    //获取成员方法和获取构造器，与获取成员变量相似
    public static void GetMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<MyClass> myClass = MyClass.class;
        //只能获取public成员方法
        //getMethod
        Method method = myClass.getMethod("publicMethod",String.class);
        System.out.println(method);//public void MyClass.publicMethod(java.lang.String)
        //getMethods
        Method[] methods = myClass.getMethods();
        System.out.print("[");//打印输出
        for(Method m : methods)
            System.out.print(m + ",");
        System.out.println("\b]");
//手动敲了换行
//[public java.lang.String MyClass.toString(),
// public void MyClass.publicMethod(java.lang.String),
// public void MyClass.setPublicField(java.lang.String),
// public java.lang.String MyClass.getPublicField(),
// public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException,
// public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException,
// public final void java.lang.Object.wait() throws java.lang.InterruptedException,
// public boolean java.lang.Object.equals(java.lang.Object),
// public java.lang.String java.lang.Object.toString(),
// public native int java.lang.Object.hashCode(),
// public final native java.lang.Class java.lang.Object.getClass(),
// public final native void java.lang.Object.notify(),
// public final native void java.lang.Object.notifyAll()]
        //获取所有的成员变量
        //getDeclaredField
        Method declaredMethod1 = myClass.getDeclaredMethod("publicMethod",String.class);
        Method declaredMethod2 = myClass.getDeclaredMethod("defaultMethod",String.class);
        Method declaredMethod3 = myClass.getDeclaredMethod("protectedMethod",String.class);
        Method declaredMethod4 = myClass.getDeclaredMethod("privateMethod",String.class);
        System.out.println(declaredMethod1);//public void MyClass.publicMethod(java.lang.String)
        System.out.println(declaredMethod2);//void MyClass.defaultMethod(java.lang.String)
        System.out.println(declaredMethod3);//protected void MyClass.protectedMethod(java.lang.String)
        System.out.println(declaredMethod4);//private void MyClass.privateMethod(java.lang.String)
        //getDeclaredFields
        Method[] declaredMethods = myClass.getDeclaredMethods();
        System.out.print("[");//打印输出
        for(Method m : declaredMethods)
            System.out.print(m + ",");
        System.out.println("\b]");
//已手动换行
//[public java.lang.String MyClass.toString(),
// private void MyClass.privateMethod(java.lang.String),
// public void MyClass.publicMethod(java.lang.String),
// public void MyClass.setPublicField(java.lang.String),
// void MyClass.defaultMethod(java.lang.String),
// protected void MyClass.protectedMethod(java.lang.String),
// public java.lang.String MyClass.getPublicField()]
        //使用Method
        MyClass myClass1 = new MyClass("Look here!");
        Object object = method.invoke(myClass1,"Haha");//publicMethod: Haha
        //无返回值，所以理应为空
        System.out.println(object);//null
        declaredMethod4.setAccessible(true);
        declaredMethod4.invoke(myClass1,"Is is a private method!");
        //privateMethod: Is is a private method!
    }
    //获取构造器
    public static void GetConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<MyClass> myClass = MyClass.class;
        //
        Constructor constructor = myClass.getConstructor(String.class);
        //可能会抛出找不到方法NoSuchMethodException异常
        System.out.println(constructor);//public MyClass(java.lang.String)
        MyClass myClass1 = (MyClass) constructor.newInstance("Public");
        System.out.println(myClass1);
        //MyClass{publicField='Public', DefaultField='null', ProtectedField='null', PrivateFiled='null'}
        MyClass myClass2 = myClass.newInstance();//直接调用空参构造器，但IDEA不建议使用该函数
        System.out.println(myClass2);
        //MyClass{publicField='null', DefaultField='null', ProtectedField='null', PrivateFiled='null'}
        /*
    Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
    Constructor<?>[] getConstructors() throws SecurityException
    Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
    Constructor<?>[] getDeclaredConstructors() throws SecurityException
    其中剩下的三种方式和GetMethod相似，这里不作演示
         */
        constructor.setAccessible(true);//修改访问权限，暴力反射,这里也可以
    }
    //后面的内容，将来可能会在这里补充
}