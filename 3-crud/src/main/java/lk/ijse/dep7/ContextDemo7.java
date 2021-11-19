package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo7 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            // 17, SELECT
            // 23, SELECT
            // sovis
            // true
            // true
            // true

            Student sovis = session.get(Student.class, 1);
            session.evict(sovis);
            sovis.setName("Nuwan");
            session.refresh(sovis);
            System.out.println(sovis.getName());
            Student sovis2 = session.get(Student.class, 1);
            System.out.println(session.contains(sovis));
            System.out.println(session.contains(sovis2));
            System.out.println(sovis == sovis2);

            session.getTransaction().commit();

        }

    }
}
