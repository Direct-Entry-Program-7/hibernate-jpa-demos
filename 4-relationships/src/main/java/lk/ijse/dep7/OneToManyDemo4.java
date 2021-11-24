package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c001 = session.get(Customer.class, "C001");
            c001.getOrderList().forEach(System.out::println);

            Customer c002 = session.get(Customer.class, "C002");
            c002.getOrderList().forEach(System.out::println);

            session.getTransaction().commit();

        }

    }
}
