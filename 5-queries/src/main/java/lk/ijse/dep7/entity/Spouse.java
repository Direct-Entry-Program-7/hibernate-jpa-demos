package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spouse")
public class Spouse implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", referencedColumnName = "id", nullable = false, unique = true)
    private Employee employee;

    public Spouse() {
    }

    public Spouse(String id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Spouse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
