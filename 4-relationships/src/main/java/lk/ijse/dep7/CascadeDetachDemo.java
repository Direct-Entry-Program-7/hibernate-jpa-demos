package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeDetachDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee e004 = session.get(Employee.class, "E004");
            Spouse spouse = e004.getSpouse();

            System.out.println("Is E004 inside the context? " + session.contains(e004));
            System.out.println("Is E004's spouse inside the context? " + session.contains(spouse));

            /* If we use Cascade.DETACH then it is going to work with both native hibernate API and JPA API */
            session.evict(e004);
//            session.detach(e004);

            System.out.println("Is E004 inside the context? " + session.contains(e004));
            System.out.println("Is E004's spouse inside the context? " + session.contains(spouse));

            session.getTransaction().commit();

        }

    }
}
