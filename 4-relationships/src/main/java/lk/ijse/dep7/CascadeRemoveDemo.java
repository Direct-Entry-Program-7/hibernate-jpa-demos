package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeRemoveDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee e004 = session.get(Employee.class, "E004");

            /* If we use Cascade.REMOVE then it is going to work with both native hibernate API and JPA API */
//            session.delete(e004);
            session.remove(e004);

            session.getTransaction().commit();

        }

    }
}
