package 集合框架;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class VectorDemo {
    /**
     * vector 和我们arraylist都是一样的vector是线程安全的。arraylist是线程不安全的。
     * 
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new Vector<>();
        list.add("good.txt");
        list.add("git add filename");
        list.add("git commit -m file name");
        list.forEach(System.out::println);
        System.out.println("----------------------------------------------set集合");
        //set集合的最大特点就是无须，不可重复
        Set<String> set = new HashSet<>();
        set.add("jinjing");
        set.add("wo");
        set.add("ai");
        set.add("ni");
        set.add("jinjing");
        set.forEach(System.out::println);
        System.out.println("----------------------------------------------set集合之treeset");
        //treeset
        Set<String> treeset = new TreeSet<>();
        treeset.add("jinjing");
        treeset.add("wo");
        treeset.add("ai");
        treeset.add("ni");
        treeset.add("jinjing");
        treeset.forEach(System.out::println);
    }
}
