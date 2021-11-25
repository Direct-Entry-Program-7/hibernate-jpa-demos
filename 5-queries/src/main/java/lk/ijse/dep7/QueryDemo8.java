package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QueryDemo8 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            // JPQL
            List<Customer> customers = session.createQuery("SELECT c FROM Customer c", Customer.class).list();
            customers.forEach(System.out::println);

            // HQL
            List<Customer> customers2 = session.createQuery("FROM Customer c", Customer.class).list();
            customers2.forEach(System.out::println);

            session.getTransaction().commit();

        }

    }
}
