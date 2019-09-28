package 集合框架;

import java.util.ArrayList;
import java.util.List;

/**
 * arraylist底层是数组结构的每次默认开辟10个内存空间。以倍数的结构增长 容许用重复数据
 * 在我们程序正常输出的时候用connection remove会导致程序异常
 * 二用iterator则不会出现异常
 * @author Administrator
 *
 */
public class Test {
//hashset  
    private static Thread thread;

    public static void main(String[] args) {
        System.out.println("HelloWorld!!");
        // arraylist 有序可重复
        List<String> all = new ArrayList<String>();
        all.add("hello");
        all.add("world");
        all.add("lu");
        all.add("jinjing");
        System.out.println(all);
    }
}
