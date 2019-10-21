package cn.mldn.daofactory;

import java.sql.Connection;

import cn.mldn.dao.IEmpDAO;
import cn.mldn.impl.EmpDAOImpl;

/**
 * @author Administrator
 * 获取empdao的实例
 * 用户无需关注类本身
 *
 */
public class EmpDAOFactory {
    
    
    public IEmpDAO getInstance(Connection connection) {
        return new EmpDAOImpl(connection);
    }
}
