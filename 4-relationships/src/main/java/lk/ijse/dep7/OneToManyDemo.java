package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.entity.Vehicle2;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c001 = new Customer("C001", "Pethum", "Galle");
            Order od001 = new Order("OD001", Date.valueOf("2021-11-21"), c001);
            Order od002 = new Order("OD002", Date.valueOf("2021-11-21"), c001);

            session.save(c001);
            session.save(od001);
            session.save(od002);

            session.getTransaction().commit();

        }

    }
}
