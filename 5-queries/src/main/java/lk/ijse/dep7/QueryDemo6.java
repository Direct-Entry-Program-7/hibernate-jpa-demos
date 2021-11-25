package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

public class QueryDemo6 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            NativeQuery query = session.createNativeQuery("INSERT INTO customer (id, name, address) VALUES (:id, :name, :address)");
            query.setParameter("id", "C004");
            query.setParameter("name", "Aruni");
            query.setParameter("address", "Matara");

//            NativeQuery query = session.createNativeQuery("INSERT INTO customer (id, name, address) VALUES (?3, ?2, ?1)");
//            query.setParameter(1, "Panadura");
//            query.setParameter(2, "Dulanga");
//            query.setParameter(3, "C003");
            int affectedRows = query.executeUpdate();

            System.out.println("Has row been added? " + (affectedRows == 1));

            session.getTransaction().commit();

        }

    }
}
