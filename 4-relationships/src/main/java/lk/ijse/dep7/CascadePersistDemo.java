package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadePersistDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Spouse s004 = new Spouse("S004", "Latha", null);
            Employee e004 = new Employee("E004", "Gayal", "Colombo", s004);
            //s004.setEmployee(e004);

            /* If we use Cascade.PERSIST then it is going to work with only JPA API */
//            session.save(e004);
            session.persist(e004);

            session.getTransaction().commit();

        }

    }
}
