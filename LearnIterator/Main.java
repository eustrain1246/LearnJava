//导入Demo的必要包
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//Main类
public class Main{
    //Main函数
    public static void main(String[] args) {
        Collection<Integer> integerCollection = new ArrayList<>();//一个集合接口的引用，指向一个ArrayList对象
        for(int i = 0; i < 10; ++i)//向集合中添加元素 1~10
            integerCollection.add(i + 1);
        Iterator<Integer> iter1 = integerCollection.iterator();//泛型迭代器，保存对应的泛型容器的迭代器
        while(iter1.hasNext()) {//检查当前迭代器后面还有没有元素，及是不是 不是最后一个元素
            int n = iter1.next();//取出下一个元素然后后移迭代器
            //思路1：
            //取出下一个位置的元素，然后将迭代器后移一位
            //思路2：
            //将迭代器后移一位，然后取出当前迭代器所指向的元素
            //上面的元素当然是类的引用
            System.out.println("iter:\t" + n);
            if(n == 5)
                //此时iter1指向的元素的值为 5
                iter1.remove();//remove 将当前迭代器指向的数据从当前迭代器所在的集合中移除
        }
        System.out.println("=================================");
        Iterator<Integer> iter2 = integerCollection.iterator();
        while(iter2.hasNext())//再次打印集合中的元素
            System.out.println("iter:\t" + iter2.next());//这里会发现没有打印数据为5的元素，因为已经被删除了
       //如果取消下行注释，那么会抛出NoSuchElementException异常
        //System.out.println("iter:\t" + iter2.next());
    }
    /**
     * 这里是一种类似于双开的结构
     * BEGIN不存元素
     * 中间存元素 
     * END不存元素
     * 初始指向BEGIN，在最后一次取值的后,迭代器指向END前一个位置也就是最后一个元素
     * 此时如果取元素，将会取出END所指向的元素，这时会抛出一个NoSuchElementException异常
     * 以上存粹个人理解，不保证其正确性
     */
}
