package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeDetachDemo3 {

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

            System.out.println("Is C001 inside the context? " + session.contains(c001));
            System.out.println("Is C001's order inside the context? " + session.contains(order));

            session.getTransaction().commit();

        }

    }
}
