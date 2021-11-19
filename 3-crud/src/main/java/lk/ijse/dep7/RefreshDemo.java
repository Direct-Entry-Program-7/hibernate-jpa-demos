package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Student student = session.get(Student.class, 1);
            System.out.println(student);
            student.setContactNumber("071-1234567");
            System.out.println(student);
            session.refresh(student);
            System.out.println(student);

            session.getTransaction().commit();

        }

    }
}
