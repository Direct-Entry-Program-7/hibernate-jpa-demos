package lk.ijse.dep7.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Contact implements Serializable {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    public Contact() {
    }

    public Contact(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
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
        return "Contact{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
