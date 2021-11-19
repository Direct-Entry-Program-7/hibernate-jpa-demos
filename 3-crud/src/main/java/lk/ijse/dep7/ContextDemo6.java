package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo6 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            // 19 SELECT
            // 23 SELECT
            // INSERT

            Student sovis = session.get(Student.class, 1);
            session.evict(sovis);
            sovis = new Student(4, "Manoj", "Matara", "011-1234567");
            Student cloned = (Student) session.merge(sovis);
            System.out.println(session.contains(sovis));
            System.out.println(session.contains(cloned));

            session.getTransaction().commit();

        }

    }
}
