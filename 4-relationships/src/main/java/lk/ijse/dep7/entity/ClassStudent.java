package lk.ijse.dep7.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Table(name = "class_student")
@Entity
public class ClassStudent implements Serializable {
    @EmbeddedId
    private ClassStudentPK classStudentPK;
    @Column(nullable = false)
    private Date date;

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
                '}';
    }
}
