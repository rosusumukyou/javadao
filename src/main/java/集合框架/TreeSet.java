package 集合框架;

import java.util.Comparator;
import java.util.Set;

/**
 * 一般我们重复元素判断是用equals方法，只用当我们用到treeset这种排序接口的时候才会用到
 * comparable接口
 * @author Administrator
 *
 */
public class TreeSet {
    public static void main(String[] args) {
        Set<Person> set = new java.util.TreeSet<>();
        set.add(new Person("张三", 12));
        set.add(new Person("张三", 12));
        set.add(new Person("李四", 18));
        set.add(new Person("王五", 23));
        set.add(new Person("赵六", 32));
        set.forEach(System.out::print);
    }
}
class Person implements Comparator{
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
        
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
}
