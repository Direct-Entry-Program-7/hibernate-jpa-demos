package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer2;
import lk.ijse.dep7.entity.Order2;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo11 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            session.getTransaction().commit();

        }

    }
}
