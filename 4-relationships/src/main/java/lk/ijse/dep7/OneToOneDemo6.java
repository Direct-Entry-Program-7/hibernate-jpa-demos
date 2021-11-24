package lk.ijse.dep7;

import lk.ijse.dep7.entity.*;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo6 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

//            Employee2 e001 = new Employee2("E001", "Pethum", "Galle");
//            Employee2 e002 = new Employee2("E002", "Sovis", "Dehiwala");
//            Employee2 e003 = new Employee2("E003", "Dinusha", "Gampaha");
//
//            Vehicle2 v001 = new Vehicle2("V001", "Car");
//            Vehicle2 v002 = new Vehicle2("V002", "Bike");
//            Vehicle2 v003 = new Vehicle2("V003", "Van");
//
//            session.save(e001);
//            session.save(e002);
//            session.save(e003);
//
//            session.save(v001);
//            session.save(v002);
//            session.save(v003);

//            Vehicle2Employee2 vehicle2Employee2 = new Vehicle2Employee2("V002", "E002", Date.valueOf("2021-11-25"));
            Vehicle2Employee2 vehicle2Employee2 = new Vehicle2Employee2("V003", "E001", Date.valueOf("2021-11-25"));

            session.save(vehicle2Employee2);

            session.getTransaction().commit();

        }

    }
}
