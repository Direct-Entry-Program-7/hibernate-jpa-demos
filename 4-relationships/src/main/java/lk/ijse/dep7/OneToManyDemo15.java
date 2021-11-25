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

public class OneToManyDemo15 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            ClassStudent cs = new ClassStudent("DEP", "S003", Date.valueOf("2021-05-05"));
            Student s006 = new Student("S006", "Hamza", "Colombo", cs);

            session.persist(s006);

            session.getTransaction().commit();

        }

    }
}
