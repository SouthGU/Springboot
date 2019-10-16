package finall;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    List<Employee> findByDepart_departName(String dname);

    @Query("select s from Employee s where s.depart.departName=?1")
    List<Employee> findEmployeesByDepartName(String dname);

    //综合训练http://localhost:8080/getIDAndNameByDepartNameAndAge?dname=soft&age=20 具有中文问题
    @Query("select s from  Employee s where  s.depart.departName=:departName and s.age<:age")
    List<Employee>  findIdAndNameByDepartNameAndAge(@Param("departName") String dname, @Param("age") int age);

    //综合训练-1
    @Query("select d.departName from Depart d inner join d.employees s where s.name=?1")
    String findDepartNameByEmployeeName(String employeeName);

    //综合训练-1
    @Modifying
    @Query("delete from Employee s where s.name=?1")
    int deleteEmployeeByEmployyName(String employeeName);
}
