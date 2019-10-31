package SpringbootDemo.demo06.demo02;

import SpringbootDemo.ComprehensiveTraining.Depart;

import javax.persistence.*;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/11:32
 * @Description:
 */
@Entity
@Table(name="demo06_employee")
public class Employee_demo06_02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = depart.class)
    @JoinColumn(name = "departId",referencedColumnName = "departNo")
    private Depart depart;


    public Employee_demo06_02() {
    }

    public Employee_demo06_02(String name, int age, Depart depart) {
        this.name = name;
        this.age = age;
        this.depart = depart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }
}
