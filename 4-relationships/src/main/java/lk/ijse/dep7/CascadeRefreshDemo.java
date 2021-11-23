package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CascadeRefreshDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee e004 = session.get(Employee.class, "E004");
            Spouse spouse = e004.getSpouse();

            System.out.println(e004);
            System.out.println(spouse);
            e004.setAddress("Moratuwa");
            spouse.setName("Seneha Latha");
            System.out.println(e004);
            System.out.println(spouse);

            session.refresh(e004);
            System.out.println(e004);
            System.out.println(spouse);

            session.getTransaction().commit();

        }

    }
}
