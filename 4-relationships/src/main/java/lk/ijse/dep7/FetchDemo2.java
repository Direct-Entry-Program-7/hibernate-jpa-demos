package lk.ijse.dep7;

import lk.ijse.dep7.entity.Movie;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FetchDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Order od001 = session.find(Order.class, "OD001");
            System.out.println(od001.getDate());
            System.out.println(od001.getCustomer() != null);
            System.out.println("--------------------------");
            System.out.println(od001.getCustomer());

            session.getTransaction().commit();

        }

    }
}
