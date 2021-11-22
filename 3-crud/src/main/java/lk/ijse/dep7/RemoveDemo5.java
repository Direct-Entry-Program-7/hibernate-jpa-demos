package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.entity.Teacher;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class RemoveDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student student = new Student(3, "Aruni", "Matara", "055-1234567");
            session.save(student);
            System.out.println("Saved");        // Saved
            session.remove(student);
            System.out.println("Deleted");      // Deleted
            session.persist(student);
            System.out.println("Persisted");    // Persisted

            session.getTransaction().commit();  // INSERT INTO

        }

    }
}
