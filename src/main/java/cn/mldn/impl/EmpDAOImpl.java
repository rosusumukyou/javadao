package cn.mldn.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpDAO;
import cn.mldn.vo.Emp;

/**
 * 数据层的实现类
 * 如果要操作此类要传入一个connection子类
 * 构造方法一定要接收一个connection对象
 * 为我们的iempdao的接口实现了一个子类
 * @author Administrator
 * 此类并没用关注数据库的打开与关闭。
 * 只需要一个数据库的连接对象即可
 *
 */
public class EmpDAOImpl implements IEmpDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EmpDAOImpl(Connection connection) {
        this.connection = connection;

    }

    @Override
    public boolean doCreate(Emp vo) throws Exception {
        // 1.准备sql语句
        String sql = "insert into emp(empno,ename,job,hiredate,sal,comm) values(?,?,?,?,?,?)";
        // 对sql语句进行预编译
        this.preparedStatement = this.connection.prepareStatement(sql);
        // 对占位符进行赋值
        this.preparedStatement.setInt(1, vo.getEmpno());
        this.preparedStatement.setString(2, vo.getEname());
        this.preparedStatement.setString(3, vo.getJob());
        this.preparedStatement.setDate(4, new java.sql.Date(vo.getHiredate().getTime()));
        this.preparedStatement.setInt(5, vo.getSal());
        this.preparedStatement.setInt(6, vo.getComm());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Emp vo) throws Exception {
        String sql = "update emp set ename=?,job=?,hiredate=?,sal=?,comm=? where empno=?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, vo.getEname());
        this.preparedStatement.setString(2, vo.getJob());
        this.preparedStatement.setDate(3, new java.sql.Date(vo.getHiredate().getTime()));
        this.preparedStatement.setInt(4, vo.getSal());
        this.preparedStatement.setInt(5, vo.getComm());
        this.preparedStatement.setInt(6, vo.getEmpno());
        // 返回执行语句影响的行数
        return this.preparedStatement.executeUpdate() > 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.mldn.dao.IEmpDAO#doRemoveBatch(java.util.Set) 按id批量删除
     * 
     */
    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        // 判断其ids是否为空，为空返回false
        if (ids == null || ids.size() == 0) {
            return false;
        }
        StringBuffer sql = new StringBuffer();
        sql.append("delete from emp where empno in(");
        Iterator<Integer> iterator = ids.iterator();
        while (iterator.hasNext()) {
            sql.append(iterator.next()).append(",");
        }
        sql.delete(sql.length() - 1, sql.length()).append(")");
        this.preparedStatement = this.connection.prepareStatement(sql.toString());
        // 判断影响的范围数是否和我们ids里面的内容一致
        return this.preparedStatement.executeUpdate() == ids.size();
    }

    @Override

    public Emp findById(Integer id) throws Exception {
        // 查询数据返回的使我们emp对象
        Emp emp = null;
        String sql = "select * from emp where empno = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet executeQuery = this.preparedStatement.executeQuery();
        if (executeQuery.next()) {
            emp = new Emp(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getInt(4), executeQuery.getDate(5), executeQuery.getInt(6), executeQuery.getInt(7),
                    executeQuery.getInt(8));
        }
        return emp;
    }

    @Override
    public List<Emp> findAll() throws Exception {
        List<Emp> list = new ArrayList<>();
        String sql = "select * from emp";
        this.preparedStatement = this.connection.prepareStatement(sql);
        ResultSet executeQuery = preparedStatement.executeQuery();
        // 循环判断，有值就加入list
        while (executeQuery.next()) {
            list.add(new Emp(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getInt(4), executeQuery.getDate(5), executeQuery.getInt(6), executeQuery.getInt(7),
                    executeQuery.getInt(8)));
        }
        return list;
    }

    @Override
    public List<Emp> findAllspit(Integer currendPage, Integer lineSizeInteger, String column, String keyWord)
            throws Exception {
        List<Emp> list = new ArrayList<>();
        String sql = "select * from emp" + " (select empno,ename,job,hiredate,sal,comm,ROWNUM rn" + " FROM emp"
                + " where " + column + " like ? and ROWNUM<=?) temp " + " where temp.rn>? ";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, "%" + keyWord + "%");
        this.preparedStatement.setInt(2, currendPage * lineSizeInteger);
        this.preparedStatement.setInt(3, (currendPage - 1) * lineSizeInteger);
        ResultSet executeQuery = preparedStatement.executeQuery();
        // 循环判断，有值就加入list
        while (executeQuery.next()) {
            Emp emp = new Emp();
            emp.setDeptno(executeQuery.getInt(1));
            emp.setEname(executeQuery.getString(2));
            emp.setJob(executeQuery.getString(3));
            emp.setHiredate(executeQuery.getDate(4));
            emp.setSal(executeQuery.getInt(5));
            emp.setComm(executeQuery.getInt(5));
            list.add(emp);
        }
        return list;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql = "select count(empno) from emp where " + column + " like ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + keyWord + "%");
        ResultSet executeQuery = this.preparedStatement.executeQuery();
        if (executeQuery.next()) {
            return executeQuery.getInt(1);
        }

        return null;
    }

}
