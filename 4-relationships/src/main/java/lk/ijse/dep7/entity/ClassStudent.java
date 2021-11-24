package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table(name = "class_student")
@Entity
public class ClassStudent implements Serializable {
    @EmbeddedId
    private ClassStudentPK classStudentPK;
    @Column(nullable = false)
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="class_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Class classRef;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    public ClassStudent() {
    }

    public ClassStudent(ClassStudentPK classStudentPK, Date date) {
        this.classStudentPK = classStudentPK;
        this.date = date;
    }

    public ClassStudent(String classId, String studentId, Date date) {
        this.classStudentPK = new ClassStudentPK(classId, studentId);
        this.date = date;
    }

    public ClassStudent(ClassStudentPK classStudentPK, Date date, Class classRef, Student student) {
        this.classStudentPK = classStudentPK;
        this.date = date;
        this.classRef = classRef;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Class getClassRef() {
        return classRef;
    }

    public ClassStudentPK getClassStudentPK() {
        return classStudentPK;
    }

    public void setClassStudentPK(ClassStudentPK classStudentPK) {
        this.classStudentPK = classStudentPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ClassStudent{" +
                "classStudentPK=" + classStudentPK +
                ", date=" + date +
                ", classRef=" + classRef +
                ", student=" + student +
                '}';
    }
}
