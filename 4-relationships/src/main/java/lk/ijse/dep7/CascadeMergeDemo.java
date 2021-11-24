package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeMergeDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee e004 = session.get(Employee.class, "E004");
            Spouse spouse = e004.getSpouse();

            System.out.println("Is E004 inside the context? " + session.contains(e004));
            System.out.println("Is E004's spouse inside the context? " + session.contains(spouse));

            /* We are going to revise this very soon */
            session.detach(e004);

            e004.setAddress("Gampaha");
            spouse.setName("Lathawathi");

            Employee clonedE004 = (Employee) session.merge(e004);
            Spouse clonedSpouse = clonedE004.getSpouse();

            System.out.println("Is E004 inside the context? " + session.contains(e004));
            System.out.println("Is E004's spouse inside the context? " + session.contains(spouse));

            System.out.println("Is E004's Clone inside the context? " + session.contains(clonedE004));
            System.out.println("Is E004's spouse's Clone inside the context? " + session.contains(clonedSpouse));

            System.out.println("Has spouse been cloned? " + (clonedSpouse != spouse));

            session.getTransaction().commit();

        }

    }
}
