package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student sovis = session.get(Student.class, 1);
            session.detach(sovis);
            System.out.println("Is Sovis inside the context? " + session.contains(sovis));
            session.update(sovis);
            System.out.println("Is Sovis inside the context? " + session.contains(sovis));

            session.getTransaction().commit();

        }

    }
}
