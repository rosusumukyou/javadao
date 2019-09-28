package 集合框架;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {
    public static void main(String[] args) {
        Vector<String> list = new Vector<>();
        list.add("tomorrow");
        list.add("double");
        list.add("");
        list.add("tomorrow");
        list.add("world");
        Enumeration<String> enumeration = list.elements();
        //遍历数组
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement() + ",");
        }
    }
}
