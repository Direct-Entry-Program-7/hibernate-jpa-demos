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

//    @SequenceGenerator(name = "seq2", sequenceName = "parent_seq", initialValue = 1, allocationSize =  1)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq2")
    @Id
    private int id;
    @Embedded
    private Contact contact;
    @Lob
    private byte[] picture;

    public Parent() {
    }

    public Parent(Contact contact, byte[] picture) {
        this.contact = contact;
        this.picture = picture;
    }

    public Parent(String name, String address, String contactNumber, byte[] picture) {
        this.contact = new Contact(name, address, contactNumber);
        this.picture = picture;
    }

    public Parent(int id, Contact contact, byte[] picture) {
        this.id = id;
        this.contact = contact;
        this.picture = picture;
    }

    public Parent(int id, String name, String address, String contactNumber, byte[] picture) {
        this.id = id;
        this.contact = new Contact(name, address, contactNumber);
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", contact=" + contact +
                '}';
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
