package hibernate.homework;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employeeName")
    private String name;
    @Column(name = "employeeLastname")
    private String lastname;
    @Column(name = "employeePosition")
    private String position;
    @Column(name = "Salary")
    private double salary;

    public Employee() {
    }

    public Employee(String name, String lastname, String position, double salary) {
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
