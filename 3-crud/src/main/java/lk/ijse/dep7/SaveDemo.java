package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class SaveDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student sovis = new Student(1, "Sovis", "Dehiwala", "077-1234567");
            Serializable id = session.save(sovis);
            System.out.println(id);

            session.getTransaction().commit();

        }

    }
}
