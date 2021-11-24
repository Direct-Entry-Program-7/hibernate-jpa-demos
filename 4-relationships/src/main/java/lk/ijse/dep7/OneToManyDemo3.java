package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c002 = new Customer("C002", "Sovis", "Dehiwala");
            Order od003 = new Order("OD003", Date.valueOf("2021-11-21"), c002);

            session.persist(od003);

            session.getTransaction().commit();

        }

    }
}
