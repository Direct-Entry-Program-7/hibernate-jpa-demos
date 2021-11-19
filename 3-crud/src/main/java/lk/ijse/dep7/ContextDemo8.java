package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo8 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student sovis = session.get(Student.class, 1);  // SELECT
            sovis.setAddress("Colombo");
            session.evict(sovis);
            Student sovis2 = session.get(Student.class, 1); // SELECT
            sovis2.setAddress("Matara");
            Student cloned = (Student) session.merge(sovis);
            System.out.println(cloned == sovis2);       // true

            session.getTransaction().commit();  // UPDATE

        }

    }
}
