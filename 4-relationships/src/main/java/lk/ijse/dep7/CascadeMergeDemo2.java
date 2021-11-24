package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeMergeDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Order od002 = session.get(Order.class, "OD002");
            Customer customer = od002.getCustomer();

            System.out.println("Is OD002 inside the context? " + session.contains(od002));
            System.out.println("Is OD002's customer inside the context? " + session.contains(customer));

            /* We are going to revise this very soon */
            session.detach(od002);

            Order clonedOd002 = (Order) session.merge(od002);
            Customer clonedCustomer = clonedOd002.getCustomer();

            System.out.println("Is OD002 inside the context? " + session.contains(od002));
            System.out.println("Is OD002's customer inside the context? " + session.contains(customer));

            System.out.println("Is OD002 inside the context? " + session.contains(clonedOd002));
            System.out.println("Is OD002's customer inside the context? " + session.contains(clonedCustomer));

            System.out.println("Has customer been cloned? " + (clonedCustomer != customer));

            session.getTransaction().commit();

        }

    }
}
