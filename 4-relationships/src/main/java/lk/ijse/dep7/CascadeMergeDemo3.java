package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class CascadeMergeDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c001 = session.get(Customer.class, "C001");
            Order order = c001.getOrderList().get(0);

            System.out.println("Is C001 inside the context? " + session.contains(c001));
            System.out.println("Is C001's order inside the context? " + session.contains(order));

            System.out.println("---------------------------------------");

            session.evict(c001);

            c001.setName("Pethum Jeewantha");
            order.setDate(Date.valueOf("2000-01-01"));

            Customer clonedC001 = (Customer) session.merge(c001);
            Order clonedOrder = clonedC001.getOrderList().get(0);       // This is not a cloned order

            System.out.println("Is C001 inside the context? " + session.contains(c001));
            System.out.println("Is C001's order inside the context? " + session.contains(order));

            System.out.println("Is C001 cloned inside the context? " + session.contains(clonedC001));
            System.out.println("Is C001's order cloned inside the context? " + session.contains(clonedOrder));

            System.out.println("Has order been cloned? " + (clonedOrder != order));

            session.getTransaction().commit();

        }

    }
}
