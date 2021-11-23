package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.entity.Vehicle;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee e002 = session.get(Employee.class, "E002");

            Vehicle v001 = new Vehicle("V001", "Car");
            Vehicle v002 = new Vehicle("V002", "Bike", e002);
            Vehicle v003 = new Vehicle("V003", "Van");

            session.save(v001);
            session.save(v002);
            session.save(v003);

            session.getTransaction().commit();

        }

    }
}
