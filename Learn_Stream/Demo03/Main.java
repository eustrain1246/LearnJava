import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
//Stream流常用方法
public class Main{
    public static void main(String[] args) {
        System.out.println("************************************************");//遍历
        Collection<String> coll1 = new ArrayList<>();
        for(int i = 1; i <= 5; ++i)coll1.add(String.valueOf(i));
        System.out.println(coll1);
        func_forEach(coll1.stream());
        System.out.println(coll1);
        System.out.println("************************************************");//计数
        Collection<String> coll2 = new ArrayList<>();
        for(int i = 1; i <= 10; ++i)coll2.add(String.valueOf(i));
        System.out.println(coll2);
        func_count(coll2.stream());
        System.out.println(coll2);
        System.out.println("************************************************");//过滤
        Collection<String> coll3 = new ArrayList<>();
        for(int i = 1; i <= 10; ++i)coll3.add(String.valueOf(i));
        System.out.println(coll3);
        func_filter(coll3.stream());
        System.out.println(coll3);
        System.out.println("************************************************");//转换
        Collection<String> coll4 = new ArrayList<>();
        for(int i = 1; i <= 5; ++i)coll4.add(String.valueOf(i));
        System.out.println(coll4);
        func_map(coll4.stream());
        System.out.println(coll4);
        System.out.println("************************************************");//截取
        Collection<String> coll5 = new ArrayList<>();
        for(int i = 1; i <= 10; ++i)coll5.add(String.valueOf(i));
        System.out.println(coll5);
        func_limit(coll5.stream());
        System.out.println(coll5);
        System.out.println("************************************************");//跳过
        Collection<String> coll6 = new ArrayList<>();
        for(int i = 1; i <= 10; ++i)coll6.add(String.valueOf(i));
        System.out.println(coll6);
        func_skip(coll6.stream());
        System.out.println(coll6);
        System.out.println("************************************************");//合并
        Collection<String> coll7_1 = new ArrayList<>();
        Collection<String> coll7_2 = new ArrayList<>();
        for(int i = 1; i <= 10; i+=2)coll7_1.add(String.valueOf(i));
        for(int i = 2; i <= 10; i+=2)coll7_2.add(String.valueOf(i));
        System.out.println(coll7_1);
        System.out.println(coll7_2);
        func_concat(coll7_1.stream(),coll7_2.stream());
        System.out.println(coll7_1);
        System.out.println(coll7_2);
        System.out.println("************************************************");
        //从上面得到打印的数组信息可以发现，使用流并不会改变集合
    }
    //遍历 终结方法
    public static void func_forEach(Stream<String> stream){
        stream.forEach(s-> System.out.println("ForEach: " + s));
    }
    //计数 终结方法
    public static void func_count(Stream<String> stream){
        System.out.println(stream.count());
    }
    //过滤
    public static void func_filter(Stream<String> stream){
        /*
        //传入一个Predicate<T>,满足条件留下
        stream.filter((s)->(int)Integer.parseInt(s) < 5);
        //打印输出
        stream.forEach((s)-> System.out.println(s));//失败，因为流只能使用一次
        */
        //读取filter作为返回值
        Stream<String> stream1 = stream.filter(s -> (int) Integer.parseInt(s) < 5);
        stream1.forEach(System.out::println);//编译器说与streamI.forEach((i)-> System.out.println(i));等价
    }
    //转换
    public static void func_map(Stream<String>stream){
        //传入一个Function<T,R>接口，将流中T类型的数据全部转化成R类型的数据
        Stream<Integer> stream1 = stream.map(s->Integer.parseInt(s) * 2);
        stream1.forEach(System.out::println);//打印输出，当然可以和上面连成一串
    }
    //截取
    public static void func_limit(Stream<String>stream){
        //截取流中的前maxSize(long)个元素，如果maxSize大于流的长度进行操作
        stream.limit(7).forEach(System.out::println);
    }
    //跳过
    public static void func_skip(Stream<String>stream){
        //跳过前n个元素,如果n大于流的长度，会将流清空
        stream.skip(3).forEach(System.out::println);
    }
    //合并 静态方法
    public static void func_concat(Stream<String> stream1,Stream<String> stream2){
        //合并两个流并返回新的流
        Stream.concat(stream1,stream2).forEach(System.out::println);
    }
}
/*粘贴自LearnInterface/Demo02
常用的函数式接口 没有写静态接口，要看自己查
    1、Supplier<T>接口：获取
        抽象方法：T get() 返回一个T类型的数据
    2、Consumer<T>接口：消费
        抽象方法：void accept(T t)                         消费一个T类型的数据
        默认方法：Consumer<T> andThen(Consumer<? super T> after)
                                                         合并当前Consumer<T>对象与参数Consumer<T> after 将合并后的对象返回
                                                         调用返回的接口对象会先执行调用andThen的接口对象，再调用after对象
    3、Predicate<T>接口：判断
        抽象方法：boolean test(T t)                        判断参数是否满足指定条件
        默认方法：Predicate<T> and(Predicate<? super T> other)
                                                         逻辑与 返回一个Predicate<T>接口对象，得到两个对象的逻辑与
                Predicate<T> or(Predicate<? super T> other)
                                                         逻辑或 返回一个Predicate<T>接口对象，得到两个对象的逻辑或
                Predicate<T> negate()                    逻辑非 返回对应为当前接口对象的逻辑非的函数对象
    4、Function<T,R>接口：转换
        抽象方法：R apply(T t)                             根据T类型的参数返回R类型的对象（将T类型的对象转换成R类型的对象）
        默认方法：<V> Function<T, V> andThen(Function<? super R, ? extends V> after)
                                                         当前接口：T->R 参数接口：R->V => 返回值接口：T->V
                <V> Function<V, R> compose(Function<? super V, ? extends T> before)
                                                         当前接口：T->R 参数接口：V->T => 返回值接口：V->R
 */
