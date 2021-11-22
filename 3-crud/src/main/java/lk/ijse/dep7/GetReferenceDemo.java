package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetReferenceDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            // Lazy Fetching
            Student student = session.getReference(Student.class, 25);
            System.out.println(student.getId());

            // Eager Fetching
            Student student1 = session.find(Student.class, 25);
            System.out.println(student.getId());

        }

    }
}
