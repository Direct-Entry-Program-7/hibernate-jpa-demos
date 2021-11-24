package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo6 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c001 = session.get(Customer.class, "C001");

            List<Order> orderList = new ArrayList<>();
            orderList.add(new Order("OD004", Date.valueOf("2021-10-01"), null));
            orderList.add(new Order("OD005", Date.valueOf("2021-10-01"), c001));
            Customer c003 = new Customer("C003", "Dinusha", "Gampaha", orderList);

            session.persist(c003);

            session.getTransaction().commit();

        }

    }
}
