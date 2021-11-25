package lk.ijse.dep7;

import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryDemo7 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            // JPQL, HQL
//            int affectedRows = session.createQuery("UPDATE lk.ijse.dep7.entity.Customer C SET C.name=?1 WHERE C.id=?2")
//                    .setParameter(1, "Aruni Dissanayake")
//                    .setParameter(2, "C004").executeUpdate();
//
//            System.out.println("Has row been updated? " + (affectedRows == 1));

            int affectedRows = session.createQuery("DELETE FROM Customer c WHERE c.id=?1")
                    .setParameter(1, "C003").executeUpdate();

            System.out.println("Has row been deleted? " + (affectedRows == 1));

            session.getTransaction().commit();

        }

    }
}
