package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;

public class QueryDemo9 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            /* INSERT INTO ... SELECT (HQL) */
            int affectedRows = session.createQuery("INSERT INTO Customer (id, name, address) SELECT s.id, s.name, s.address FROM Student s").executeUpdate();
            System.out.println(affectedRows);

            session.getTransaction().commit();

        }

    }
}
