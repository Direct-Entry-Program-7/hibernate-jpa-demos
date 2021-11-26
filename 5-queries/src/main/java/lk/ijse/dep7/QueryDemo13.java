package lk.ijse.dep7;

import lk.ijse.dep7.entity.CustomEntity;
import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDemo13 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            /* Native Hibernate API */
            List<Customer> customerList1 = session.getNamedQuery("findCustomersByAddress")
                    .setParameter("q", "Gal")
                    .list();

            customerList1.forEach(System.out::println);

            List<Customer> customerList2 = session.getNamedQuery("findCustomersByName")
                    .setParameter(1, "Pet").list();

            customerList2.forEach(System.out::println);

            /* JPA API */
            List<Customer> customerList3 = session.createNamedQuery("findCustomersByAddress").
                    setParameter("q", "Gal").list();

            customerList3.forEach(System.out::println);

            System.out.println("============================ Named Native Queries ==========================");

            /* Native Hibernate API */
            List employeeNameList1 = session.getNamedNativeQuery("getEmployeeNames").list();
            employeeNameList1.forEach(System.out::println);

            /* JPA API */
            List employeeNameList2 = session.createNamedQuery("getEmployeeNames").list();
            employeeNameList2.forEach(System.out::println);

            session.getTransaction().commit();

        }

    }
}
