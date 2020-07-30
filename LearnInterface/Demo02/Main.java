import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
/*
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
//函数式接口的判定：抽象方法有且只有一个的接口
//快速判定↓ 当然下面不是个接口，也不是抽象类，更没有抽象方法
//@FunctionalInterface
class Main{
    public static void main(String[] args) {
        Supplier<String> supplier;
        Consumer<String> consumer;
        Predicate<String> predicate;
        Function<String,Integer>integerFunction;
    }
}
