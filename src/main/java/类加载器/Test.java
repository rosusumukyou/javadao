package 类加载器;

import cn.mldn.jdbc.DbConnection;

public class Test {
    public static void main(String[] args) {
        //获取连接
        System.out.println(new DbConnection().getConnection());
    }
}
