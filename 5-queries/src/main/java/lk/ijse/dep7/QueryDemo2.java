package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class QueryDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();){

            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM customer");
            nativeQuery.addEntity(Customer.class);

            List<Customer> list = nativeQuery.list();
            Customer c001 = list.get(0);
            System.out.println("ID: " + c001.getId());
            System.out.println("Name: " + c001.getName());
            System.out.println("Address: " + c001.getAddress());

            System.out.println("--------------------");

            System.out.println("ID: " + list.get(1).getId());
            System.out.println("name: " + list.get(1).getName());
            System.out.println("name: " + list.get(1).getAddress());

        }

    }
}
