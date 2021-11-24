package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee2;
import lk.ijse.dep7.entity.Vehicle2;
import lk.ijse.dep7.entity.Vehicle2Employee2;
import lk.ijse.dep7.entity.Vehicle2Employee2PK;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo8 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee2 e003 = session.get(Employee2.class, "E003");
            Vehicle2 v001 = session.get(Vehicle2.class, "V001");

            //Vehicle2Employee2 ve002= new Vehicle2Employee2("V001", "E003", Date.valueOf("2021-11-25"));

//            Vehicle2Employee2 ve002 = new Vehicle2Employee2();
//            ve002.setVehicle2Employee2PK(new Vehicle2Employee2PK("V001", "E003"));
//            ve002.setDate(Date.valueOf("2021-11-25"));

//            Vehicle2Employee2 ve002 = new Vehicle2Employee2();
//            ve002.setDate(Date.valueOf("2021-11-25"));
//            ve002.setVehicle2(v001);
//            ve002.setEmployee2(e003);
//
//            session.persist(ve002);

            session.getTransaction().commit();

        }

    }
}
