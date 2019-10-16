package finall;


import javax.persistence.*;

@Entity
@Table(name="tb_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int  age;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Depart.class)
    @JoinColumn(name = "departId",referencedColumnName = "departNo")
    private Depart depart;

    public Employee(){}
    public Employee(String name, int age, Depart depart) {
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
