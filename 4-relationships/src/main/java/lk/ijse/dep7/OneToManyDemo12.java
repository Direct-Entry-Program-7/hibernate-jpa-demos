package lk.ijse.dep7;

import lk.ijse.dep7.entity.Class;
import lk.ijse.dep7.entity.ClassStudent;
import lk.ijse.dep7.entity.ClassStudentPK;
import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo12 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            ClassStudent classStudent = session.get(ClassStudent.class, new ClassStudentPK("MAD", "S003"));

            Class dep = session.find(Class.class, "DEP");
//            List<ClassStudent> newClassStudentList = new ArrayList<>();
//            newClassStudentList.addAll(dep.getClassStudentList());
//            newClassStudentList.add(classStudent);
//            dep.setClassStudentList(newClassStudentList);

            session.getTransaction().commit();

        }

    }
}
