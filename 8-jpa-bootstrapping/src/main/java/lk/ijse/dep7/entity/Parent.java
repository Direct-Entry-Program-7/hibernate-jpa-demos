package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

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
    private Blob picture;

    public Parent() {
    }

    public Parent(Contact contact, Blob picture) {
        this.contact = contact;
        this.picture = picture;
    }

    public Parent(String name, String address, String contactNumber, Blob picture) {
        this.contact = new Contact(name, address, contactNumber);
        this.picture = picture;
    }

    public Parent(int id, Contact contact, Blob picture) {
        this.id = id;
        this.contact = contact;
        this.picture = picture;
    }

    public Parent(int id, String name, String address, String contactNumber, Blob picture) {
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

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }
}
