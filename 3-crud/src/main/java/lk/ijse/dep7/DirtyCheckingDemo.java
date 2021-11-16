package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DirtyCheckingDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student pethum = session.find(Student.class, 2);
            System.out.println(pethum);
            pethum.setContactNumber("011-123456789");
            System.out.println("Changed the phone number");
            session.detach(pethum);

            session.getTransaction().commit();

        }

    }
}
