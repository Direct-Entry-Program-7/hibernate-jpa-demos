package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee2;
import lk.ijse.dep7.entity.Vehicle2;
import lk.ijse.dep7.entity.Vehicle2Employee2;
import lk.ijse.dep7.entity.Vehicle2Employee2PK;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo7 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Vehicle2 v004 = new Vehicle2("V004", "BMW Car");
            Employee2 e004 = new Employee2("E004", "Dulanga", "Matara");

            Vehicle2Employee2 ve001 = new Vehicle2Employee2(new Vehicle2Employee2PK(v004.getNumber(), e004.getId()),
                    Date.valueOf("2021-11-25"), v004, e004);
            session.persist(ve001);

            session.getTransaction().commit();

        }

    }
}
