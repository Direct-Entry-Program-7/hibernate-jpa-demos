package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Vehicle;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            //Vehicle v004 = new Vehicle("V004", "Car");
            Vehicle v001 = session.get(Vehicle.class, "V001");
            Employee e005 = new Employee("E005", "Hamza", "Colombo", v001);

            session.persist(e005);

            session.getTransaction().commit();

        }

    }
}
