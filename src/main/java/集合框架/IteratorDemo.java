package 集合框架;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * listiterator支持反向迭代
 * 转移字符\n
 * @author Administrator
 *
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("tomorrow");
        list.add("double");
        list.add("");
        list.add("tomorrow");
        list.add("world");
        ListIterator<String> listIterator = list.listIterator();
        System.out.println("正向迭代！");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ",");
        }
        System.out.println("\n反向迭代！");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ",");
        }
    }

}
