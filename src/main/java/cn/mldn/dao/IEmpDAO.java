package cn.mldn.dao;

import java.util.List;
import java.util.Set;

import cn.mldn.vo.Emp;

/**
 * 
 * 此接口定义我们数据层的操作方法
 * 
 * @author Administrator
 *
 */
public interface IEmpDAO {

    /**
     * 完成添加操作。
     * 
     * @param vo
     *            添加的EMP对象。
     * @return 成功返回true，失败返回false。
     * @throws Exception
     *             sql执行异常。
     */
    public boolean doCreate(Emp vo) throws Exception;

    /**
     * 完成我们的修改操作。
     * 
     * @param vo
     *            修改的对象。
     * @return 修改成功返回true，修改失败返回false。
     * @throws Exception
     *             执行的sql异常。
     */
    public boolean doUpdate(Emp vo) throws Exception;

    /**
     * 批量删除
     * 
     * @param ids
     *            以id删除，不容许重复
     * @return 删除成功返回true，删除失败返回false。
     * @throws Exception
     *             sql执行异常。
     */
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    /**
     * 
     * 根据id查找数据。
     * 
     * @param id
     *            record的id。
     * @return 返回的id对选哪个。
     * @throws Exception
     *             sql执行异常。
     */
    public Emp findById(Integer id) throws Exception;

    /**
     * 查询所有。
     * 
     * @return 返回emp的list集合对象。
     * @throws Exception
     *             sql执行异常。
     */
    public List<Emp> findAll() throws Exception;

    /**
     * 分页查询
     * 
     * @param currendPage
     *            当前页数。
     * @param lineSizeInteger
     *            每页显示的条数。
     * @param column
     *            要进行模糊查询的数列数
     * 
     * @param keyWord
     *            模糊查询的关键字
     * @return 返回封装的list集合对象
     * @throws Exception
     *             sql执行异常
     */
    public List<Emp> findAllspit(Integer currendPage, Integer lineSizeInteger, String column, String keyWord)
            throws Exception;

    /**
     * 进行模糊查询的数据的统计，没有数据返回0
     * 
     * @param column
     *            要进行模糊查询的数据列
     * @param keyWord
     *            模糊查询的关键字
     * @return 返回查询的总数
     * @throws Exception
     *             sql执行异常
     */
    public Integer getAllCount(String column, String keyWord) throws Exception;

}
