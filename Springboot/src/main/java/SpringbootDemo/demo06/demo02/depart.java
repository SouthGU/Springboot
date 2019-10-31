package SpringbootDemo.demo06.demo02;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/11:34
 * @Description:
 */

@Entity
@Table(name = "demo07_depart")
public class depart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departNo;
    private String departName;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Employee_demo06_02.class,mappedBy = "depart")
    private Set<Employee_demo06_02> employees = new HashSet<>();

    public depart() {
    }

    public depart(String departName, Set<Employee_demo06_02> employees) {
        this.departName = departName;
        this.employees = employees;
    }

    public int getDepartNo() {
        return departNo;
    }

    public void setDepartNo(int departNo) {
        this.departNo = departNo;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Set<Employee_demo06_02> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee_demo06_02> employees) {
        this.employees = employees;
    }
}
