package lk.ijse.dep7;

import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import java.util.List;

public class QueryDemo1 {

    public static void main(String[] args) {

        try(SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();){

            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM customer");
            List<Object[]> list = nativeQuery.list();
            Object[] row1 = list.get(0);
            System.out.println("ID: " + row1[0]);
            System.out.println("Name: " + row1[1]);
            System.out.println("Address: " + row1[2]);

            System.out.println("--------------------");

            System.out.println("ID: " + list.get(1)[0]);
            System.out.println("name: " + list.get(1)[1]);
            System.out.println("name: " + list.get(1)[2]);

        }

    }
}
