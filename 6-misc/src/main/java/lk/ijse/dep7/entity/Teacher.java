package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

//    @SequenceGenerator(name = "seq1", sequenceName = "teacher_seq", initialValue = 1, allocationSize = 1)
//    @SequenceGenerator(name = "seq2", sequenceName = "teacher_seq2", initialValue = 10, allocationSize = 10)
//    @SequenceGenerator(name = "seq3", sequenceName = "teacher_seq2", initialValue = 1, allocationSize = 5)

    @TableGenerator(name = "tbl",
            table = "incremented_id",
            pkColumnName = "table_name",
            valueColumnName = "value",
            pkColumnValue = "teacher",
            initialValue = 0,
            allocationSize = 10
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl")
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private MarriedStatus marriedStatus;

    @AttributeOverride(name="name", column = @Column(name="full_name", nullable = false))
    @AttributeOverride(name="contactNumber", column =  @Column(name="telephone", nullable = false))
    @Embedded
    private Contact contact;

    public Teacher() {
    }

    public Teacher(Gender gender, MarriedStatus marriedStatus, Contact contact) {
        this.gender = gender;
        this.marriedStatus = marriedStatus;
        this.contact = contact;
    }

    public Teacher(String name, String address, String contactNumber, Gender gender, MarriedStatus marriedStatus) {
        this.gender = gender;
        this.marriedStatus = marriedStatus;
        this.contact = new Contact(name, address, contactNumber);
    }

    public Teacher(int id, Gender gender, MarriedStatus marriedStatus, Contact contact) {
        this.id = id;
        this.gender = gender;
        this.marriedStatus = marriedStatus;
        this.contact = contact;
    }

    public Teacher(int id, String name, String address, String contactNumber, Gender gender, MarriedStatus marriedStatus) {
        this.id = id;
        this.gender = gender;
        this.marriedStatus = marriedStatus;
        this.contact =  new Contact(name, address, contactNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", gender=" + gender +
                ", marriedStatus=" + marriedStatus +
                ", contact=" + contact +
                '}';
    }
}
