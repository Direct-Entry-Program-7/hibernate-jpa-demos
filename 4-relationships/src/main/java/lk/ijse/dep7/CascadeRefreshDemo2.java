package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class CascadeRefreshDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Order od003 = session.get(Order.class, "OD003");
            Customer c002 = od003.getCustomer();

            System.out.println(od003);
            System.out.println(c002);
            od003.setDate(Date.valueOf("2020-10-01"));
            c002.setName("Cisco");
            System.out.println(od003);
            System.out.println(c002);

            session.refresh(od003);
            System.out.println(od003);
            System.out.println(c002);
            session.getTransaction().commit();

        }

    }
}
