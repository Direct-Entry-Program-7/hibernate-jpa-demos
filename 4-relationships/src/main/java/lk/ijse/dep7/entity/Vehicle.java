package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
    @Id
    private String number;
    @Column(nullable = false)
    private String type;
    @OneToOne
    @JoinTable(name="vehicle_employee",
                joinColumns = @JoinColumn(name="number", referencedColumnName = "number"),
                inverseJoinColumns = @JoinColumn(name="employee_id", referencedColumnName = "id", unique = true))
    private Employee employee;

    public Vehicle() {
    }

    public Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public Vehicle(String number, String type, Employee employee) {
        this.number = number;
        this.type = type;
        this.employee = employee;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", employee=" + employee +
                '}';
    }
}
