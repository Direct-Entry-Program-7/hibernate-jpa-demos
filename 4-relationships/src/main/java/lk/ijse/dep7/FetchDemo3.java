package lk.ijse.dep7;

import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FetchDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Spouse s001 = session.find(Spouse.class, "S001");
            System.out.println(s001.getName());
            System.out.println(Hibernate.isInitialized(s001.getEmployee()));
            System.out.println(s001.getEmployee() != null);
            System.out.println("------------");
            System.out.println(s001.getEmployee().getName());
            System.out.println(Hibernate.isInitialized(s001.getEmployee()));

            session.getTransaction().commit();

        }

    }
}
