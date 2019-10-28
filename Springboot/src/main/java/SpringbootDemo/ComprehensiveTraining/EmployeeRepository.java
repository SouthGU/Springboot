package SpringbootDemo.ComprehensiveTraining;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    List<Employee> findByDepart_departName(String dname);

    @Query("select s from Employee s where s.depart.departName=?1")
    List<Employee> findEmployeesByDepartName(String dname);

    /**
      * 查询所在部门 和 年龄小于XX岁的员工
      * @Author: COM.SISE.XGL
      * @Date: 2019/10/20 0:35
      * @param dname
      * @param age
      * @return java.util.List<SpringbootDemo.ComprehensiveTraining.Employee>
      * @Description: 综合训练
    **/
    //@Query("select s from  Employee s where  s.depart.departName=:departName and s.age<:age")
    @Query("select s from  Employee s where  s.depart.departName=?1 and s.age<?2")
    List<Employee>  findIdAndNameByDepartNameAndAge(@Param("departName") String dname, @Param("age") int age);

    /**
      * 描述一下方法的作用
      * @Author: COM.SISE.XGL
      * @Date: 2019/10/20 0:36
      * @param employeeName 根据名字查找部门名字
      * @return java.util.List<java.lang.String>
      * @Description: 综合训练-1
    **/
    @Query("select d.departName from Depart d inner join d.employees s where s.name=?1")
    List<String> findDepartNameByEmployeeName(String employeeName);

    /**
      * 描述一下方法的作用
      * @Author: COM.SISE.XGL
      * @Date: 2019/10/20 0:37
      * @param employeeName
      * @return int
      * @Description: 综合训练-1
    **/
    @Modifying //通知jpa这是一个update或者delete操作，jpql不支持insert操作。表明下面需要对数据进行修改。
    @Query("delete from Employee s where s.name=?1")
    int deleteEmployeeByEmployyName(String employeeName);

    /**
      * 描述一下方法的作用
      * @Author: COM.SISE.XGL
      * @Date: 2019/10/20 0:40
      * @param employeeName 根据名称查询人数
      * @return int
      * @Description:
    **/
    @Query("select count(s.name) from Employee s where s.name=?1")
    int queryEmployeeByName(String employeeName);
}
