import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
//获取Stream流
public class Main{
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        for(int i = 1; i <= 10; ++i)coll.add(String.valueOf(i));
        func_filter(coll.stream());

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
        Stream<String> stream1 = stream.filter((s) -> (int) Integer.parseInt(s) < 5);
        stream1.forEach((s)-> System.out.println(s));
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
