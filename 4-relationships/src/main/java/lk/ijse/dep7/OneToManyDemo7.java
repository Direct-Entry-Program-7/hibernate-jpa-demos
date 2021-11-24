package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Customer2;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.entity.Order2;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo7 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer2 c001 = new Customer2("C001", "Pethum", "Galle");
            Customer2 c002 = new Customer2("C002", "Sovis", "Moratuwa");

            Order2 od001 = new Order2("OD001", Date.valueOf("2021-11-25"));
            Order2 od002 = new Order2("OD002", Date.valueOf("2021-11-20"),c001);
            Order2 od003 = new Order2("OD003", Date.valueOf("2021-11-25"),c001);

//            session.save(c001);
            session.save(c002);
            session.save(od001);
            session.persist(od002);
            session.persist(od003);

            session.getTransaction().commit();

        }

    }
}
