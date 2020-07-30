import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
//获取Stream流
public class Main{
    public static void main(String[] args) {
        Collection<String> stringCollection = new ArrayList<>();
        for(int i = 1; i <= 10; ++i)
            stringCollection.add(String.valueOf(i));
        //输出以下集合中的内容
        System.out.println(stringCollection);
        //生成一个流对象
        Stream<String> stream1 = stringCollection.stream();
/*************************************************************
 流模型的操作大致可以分为两种：
 * 延迟方法 返回完成执行完毕后产生的新的流，可以链式调用
 * 终结方法 不支持链式调用，如count和forEach
 流在被使用一次后就会被关闭,不能再次使用，无论是延迟方法还是终结方法，到;就结束了
**************************************************************/
        //下面两格函数调用只能调用一个，如果同时调用，后面的那个会抛出一个异常
        // 流对象中包含的数量
        //System.out.println(stream1.count());
        //对流中的每一个对象，施加传进去的Consumer接口对象
        stream1.forEach((s)-> {
            System.out.print("Try exchange " + s);
            //只是改变了String类型的引用指向的值，并没有改变Collection中的元素
            s = String.valueOf(10 - (int)Integer.parseInt(s));
            System.out.println(" to " + s);
        });
/*+************************************************************+*/
        //再次打印集合中的元素
        System.out.println(stringCollection);
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
