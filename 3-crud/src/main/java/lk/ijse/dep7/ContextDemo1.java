package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class ContextDemo1 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            // SELECT
            // SELECT
            // UPDATE

            Student student = session.get(Student.class, 1);
            session.detach(student);
            session.refresh(student);
            student.setContactNumber("077-1234567");

            session.getTransaction().commit();

        }

    }
}
