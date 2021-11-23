package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Vehicle;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Vehicle v002 = session.get(Vehicle.class, "V002");
            System.out.println(v002);

            Employee e002 = session.get(Employee.class, "E002");
            System.out.println(e002.getVehicle());

            Employee e001 = session.get(Employee.class, "E001");
            System.out.println(e001.getVehicle());

            session.getTransaction().commit();

        }

    }
}
