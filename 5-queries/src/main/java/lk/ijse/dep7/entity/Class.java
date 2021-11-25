package lk.ijse.dep7.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "class")
@Entity
public class Class implements Serializable {

    @Id
    private String id;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "classRef", cascade = {CascadeType.PERSIST})
    private List<ClassStudent> classStudentList;

    public Class() {
    }

    public Class(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Class(String id, String description, List<ClassStudent> classStudentList) {
        this.id = id;
        this.description = description;
        this.classStudentList = classStudentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public List<ClassStudent> getClassStudentList() {
        return classStudentList;
    }

    @PrePersist
    private void beforePersist(){
        if (this.classStudentList != null){
            this.classStudentList.forEach(cs -> cs.getClassStudentPK().setClassId(id));
        }
    }

//    public void setClassStudentList(List<ClassStudent> classStudentList) {
//        this.classStudentList = classStudentList;
//    }
}
