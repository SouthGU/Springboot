package SpringbootDemo.demo06.demo02;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/11:40
 * @Description:
 */
public interface EmployeeRepository_demo06_02 extends JpaRepository<Employee_demo06_02,Integer> {

    List<Employee_demo06_02> findByDepart_DepartName(String dname);

    @Query("select s from Employee_demo06_02 s where  s.depart.departName=?1")
    List<Employee_demo06_02> findEmployeesByDepartName(String dname);
}
