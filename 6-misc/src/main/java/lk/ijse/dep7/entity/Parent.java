package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "parent")
@Entity
public class Parent implements Serializable {

    @TableGenerator(name = "tbl",
            table = "incremented_id",
            pkColumnName = "table_name",
            valueColumnName = "value",
            pkColumnValue = "parent",
            initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl")
    @SequenceGenerator(name = "seq2", sequenceName = "parent_seq", initialValue = 1, allocationSize =  1)

    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "seq2")
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, name = "contact_number")
    private String contactNumber;

    public Parent() {
    }

    public Parent(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Parent(int id, String name, String address, String contactNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
