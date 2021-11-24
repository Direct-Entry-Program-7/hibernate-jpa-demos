package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee2;
import lk.ijse.dep7.entity.Vehicle2;
import lk.ijse.dep7.entity.Vehicle2Employee2;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo9 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

//            Vehicle2Employee2 ve00 = new Vehicle2Employee2("V005", "E003", Date.valueOf("2021-01-01"));
//            Vehicle2 v005 = new Vehicle2("V005", "BMW Bike", ve00);
//
//            session.persist(v005);

            Vehicle2 v005 = session.get(Vehicle2.class, "V005");
            System.out.println(v005.getVehicle2Employee2());

            session.getTransaction().commit();

        }

    }
}
