package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveOrUpdateDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student manoj = new Student(4, "Manoj", "Galle", "011-1234567");
            Student sovis = new Student(1, "Sovis", "Colombo", "011-1234567");

            session.saveOrUpdate(manoj);    // SELECT
            System.out.println("Manoj has been saved");
            session.saveOrUpdate(sovis);    // SELECT
            System.out.println("Sovis has been updated");

            session.getTransaction().commit();  // INSERT INTO, UPDATE

        }

    }
}
