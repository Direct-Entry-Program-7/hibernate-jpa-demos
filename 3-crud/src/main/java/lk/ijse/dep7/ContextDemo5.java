package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            // 19 -> SELECT
            // 23 -> SELECT
            // 2, Sovis
            // UPDATE

            Student sovis = session.get(Student.class, 1);
            session.evict(sovis);
            sovis.setId(2);
            Student pethum = session.get(Student.class, 2);
            Student cloned = (Student) session.merge(sovis);
            System.out.println(cloned);

            session.getTransaction().commit();

        }

    }
}
