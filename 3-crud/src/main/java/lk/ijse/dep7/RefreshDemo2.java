package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo2 {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // transient state (new state), detached state
//            Student student = new Student(2, "Aruni", "Matara", "011-1234567");
//            session.refresh(student);

            Student student = session.get(Student.class, 1);
            session.evict(student);
            System.out.println("Student has been detached");
            System.out.println("Is student inside the cache? " + session.contains(student));
            session.refresh(student);
            System.out.println("Student has been refreshed");
            System.out.println("Is student inside the cache? " + session.contains(student));

            session.getTransaction().commit();

        }

    }
}
