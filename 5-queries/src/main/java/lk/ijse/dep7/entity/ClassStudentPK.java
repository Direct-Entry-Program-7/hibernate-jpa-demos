package lk.ijse.dep7.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClassStudentPK implements Serializable {

    @Column(name = "class_id")
    private String classId;
    @Column(name = "student_id", unique = true)
    private String studentId;

    public ClassStudentPK() {
    }

    public ClassStudentPK(String classId, String studentId) {
        this.classId = classId;
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "ClassStudentPK{" +
                "classId='" + classId + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
