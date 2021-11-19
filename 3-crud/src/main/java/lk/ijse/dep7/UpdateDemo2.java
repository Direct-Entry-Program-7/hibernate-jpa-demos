package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student sovis = session.get(Student.class, 1);
            sovis.setContactNumber("011-4567891");
            //session.update(sovis);
            System.out.println("Sovis has been updated");

            session.getTransaction().commit();

        }

    }
}
