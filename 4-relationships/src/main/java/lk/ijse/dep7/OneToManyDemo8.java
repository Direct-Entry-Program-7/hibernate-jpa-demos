package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer2;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.entity.Order2;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo8 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Order2 od003 = session.get(Order2.class, "OD003");
            od003.setCustomer(null);

            session.getTransaction().commit();

        }

    }
}
