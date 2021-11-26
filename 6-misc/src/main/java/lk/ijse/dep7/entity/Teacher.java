package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(name = "contact_number", nullable = false)
    private String contactNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private MarriedStatus marriedStatus;

    public Teacher() {
    }

    public Teacher(int id, String name, String address, String contactNumber, Gender gender, MarriedStatus marriedStatus) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.marriedStatus = marriedStatus;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MarriedStatus getMarriedStatus() {
        return marriedStatus;
    }

    public void setMarriedStatus(MarriedStatus marriedStatus) {
        this.marriedStatus = marriedStatus;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", gender=" + gender +
                ", marriedStatus=" + marriedStatus +
                '}';
    }
}
