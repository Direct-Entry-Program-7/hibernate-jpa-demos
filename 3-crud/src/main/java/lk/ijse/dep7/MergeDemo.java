package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Student sovis = session.get(Student.class, 1);
            session.detach(sovis);
            // sovis can be in the detached or transient state (detach)
            System.out.println("Is Sovis inside the context? " + session.contains(sovis));

            Student cloned = (Student) session.merge(sovis);
            System.out.println("Is Sovis inside the context? " + session.contains(sovis));
            sovis.setContactNumber("071-1234567");
            System.out.println(sovis);

            System.out.println("------------ Cloned ----------------");
            System.out.println(cloned);
            cloned.setContactNumber("071-1234567");
            System.out.println("Is Cloned inside the context? " + session.contains(cloned));

            session.getTransaction().commit();

        }

    }
}
