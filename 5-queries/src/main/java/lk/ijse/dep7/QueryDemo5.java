package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

public class QueryDemo5 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            NativeQuery<Customer> query1 = session.createNativeQuery("SELECT * FROM customer WHERE id=?1", Customer.class);
            query1.setParameter(1, "C001");
            Customer customer1 = query1.getSingleResult();
            System.out.println(customer1);

            NativeQuery<Customer> query2 = session.createNativeQuery("SELECT * FROM customer WHERE id=:abc", Customer.class);
            query2.setParameter("abc", "C002" );
            Customer customer2 = query2.uniqueResult();
            System.out.println(customer2);

        }

    }
}
