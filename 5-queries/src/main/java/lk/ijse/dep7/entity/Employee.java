package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@NamedNativeQuery(name = "getEmployeeNames", query = "SELECT name FROM employee")
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;

    //    @Cascade(org.hibernate.annotations.CascadeType.)
    // CascadeType.All (JPA) = CascadeType.All (Native Hibernate)
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne(mappedBy = "employee", cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Spouse spouse;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private Vehicle vehicle;

    public Employee() {
    }

    public Employee(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Employee(String id, String name, String address, Spouse spouse) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spouse = spouse;
        this.spouse.setEmployee(this);
    }

    public Employee(String id, String name, String address, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vehicle = vehicle;
        this.vehicle.setEmployee(this);
    }

    public Employee(String id, String name, String address, Spouse spouse, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spouse = spouse;
        this.vehicle = vehicle;
        this.spouse.setEmployee(this);
        this.vehicle.setEmployee(this);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        spouse.setEmployee(this);
        this.spouse = spouse;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        vehicle.setEmployee(this);
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
