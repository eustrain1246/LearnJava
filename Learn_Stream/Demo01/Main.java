import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;
//获取Stream流
public class Main{
    public static void main(String[] args) {
        //流的构造
        //方法1：把调用集合Collection的stream函数将其转换为Stream流
        Collection<String> stringCollection = new ArrayList<>();
        //map不能直接转化，
        //但是可以通过.keySet函数将键转化为Set
        //或者通过.values将值转化为Collection集合
        //还有.entrySet将键值对转化为Set
        //Collection<Integer> c = new HashMap<Integer,String>();
        for(int i = 1; i <= 10; ++i)
            stringCollection.add(String.valueOf(i));
        Stream<String> Stream1 = stringCollection.stream();
        //方法2：利用Stream类的静态方法of，直接生成流
        Stream<String> stream2 = Stream.of("123", "234", "345", "456");//可变参数
        String[] strings = new String[]{"321","432","543","654"};//数组，其实也是可变参数的那个重载
        stream2 = Stream.of(strings);
    }
}
