package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeDetachDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Order od002 = session.get(Order.class, "OD002");
            Customer customer = od002.getCustomer();

            System.out.println("Is OD002 inside the context? " + session.contains(od002));
            System.out.println("Is OD002's customer inside the context? " + session.contains(customer));

            /* If we use CascadeType.DETACH then it is going to work with both native hibernate API and JPA API */
            session.evict(od002);
//            session.detach(e004);

            System.out.println("Is OD002 inside the context? " + session.contains(od002));
            System.out.println("Is OD002's customer inside the context? " + session.contains(customer));

            session.getTransaction().commit();

        }

    }
}
