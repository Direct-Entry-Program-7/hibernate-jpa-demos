package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeRemoveDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            /* Try this with a customer who has more than one order  */
            Order od002 = session.get(Order.class, "OD002");
            session.remove(od002);

            session.getTransaction().commit();

        }

    }
}
