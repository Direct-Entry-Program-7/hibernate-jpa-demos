package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import java.util.List;

public class QueryDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();){

            NativeQuery query1 = session.createNativeQuery("SELECT * FROM customer WHERE id='C001'");
            Object[] customer1 = (Object[]) query1.uniqueResult();
            System.out.println(customer1[0]);

            /* Native Hibernate API (NativeQuery<T>), JPA API (Query) */
            NativeQuery<Customer> query2 = session.createNativeQuery("SELECT * FROM customer WHERE id='C001'", Customer.class);
            Customer customer2 = query2.uniqueResult(); // getSingleResult()
            System.out.println(customer2);

            /* Native Hibernate API */
            NativeQuery query3 = session.createNativeQuery("SELECT * FROM customer WHERE id='C001'");
            query3.addEntity(Customer.class);
            Customer customer3 = (Customer) query3.getSingleResult();
            System.out.println(customer3);

            /* Native Hibernate API */
            NativeQuery<Customer> query4 = session.createNativeQuery("SELECT * FROM customer WHERE id='C001'").addEntity(Customer.class);
            Customer customer4 = query4.getSingleResult();
            System.out.println(customer4);

        }

    }
}
