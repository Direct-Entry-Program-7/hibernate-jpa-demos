package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EvictDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            Student student = session.find(Student.class, 1);
            System.out.println(student);
            System.out.println("Is student inside the context? " + session.contains(student));
            session.evict(student);
            System.out.println("Is student inside the context? " + session.contains(student));

        }

    }
}
