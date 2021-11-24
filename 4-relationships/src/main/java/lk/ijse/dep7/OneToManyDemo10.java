package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer2;
import lk.ijse.dep7.entity.Order2;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo10 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            List<Order2> orderList = new ArrayList<>();
            Customer2 c003 = new Customer2("C003", "Gayal", "Gampaha", orderList);
            orderList.add(new Order2("OD004", Date.valueOf("2021-01-01")));

            session.persist(c003);

            session.getTransaction().commit();

        }

    }
}
