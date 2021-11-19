package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student dinusha = session.get(Student.class, 3);
            session.remove(dinusha);
            System.out.println("Is Dinusha inside the context? " + session.contains(dinusha));
            session.save(dinusha);
            System.out.println("Is Dinusha inside the context? " + session.contains(dinusha));

            session.getTransaction().commit();

        }

    }
}
