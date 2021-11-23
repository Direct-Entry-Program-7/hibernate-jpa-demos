package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();


            session.getTransaction().commit();

        }

    }
}
