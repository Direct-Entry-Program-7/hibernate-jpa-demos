package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class CascadeRefreshDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c001 = session.get(Customer.class, "C001");
            System.out.println(c001.getOrderList().get(0));

            System.out.println("---------------------------------");

            c001.setName("Pethum Jeewantha");
            c001.getOrderList().get(0).setDate(Date.valueOf("1880-01-01"));
            System.out.println(c001.getOrderList().get(0));

            System.out.println("---------------------------------");

            session.refresh(c001);
            System.out.println(c001.getOrderList().get(0));

            session.getTransaction().commit();

        }

    }
}
