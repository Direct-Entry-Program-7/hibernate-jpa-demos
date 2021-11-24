package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Customer2;
import lk.ijse.dep7.entity.Order2;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class OneToManyDemo9 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer2 c001 = session.get(Customer2.class, "C001");
            Order2 od001 = session.get(Order2.class, "OD001");

            // If it says by the O.E, then it is going to insert a new record
//            od001.setCustomer(c001);
            // If it says by the I.E, then it is not going to insert a new record
            //c001.getOrderList().add(od001);

            ArrayList<Order2> orderList = new ArrayList<>();
            orderList.addAll(c001.getOrderList());  // OD002
            orderList.add(od001);
            c001.setOrderList(orderList);

            session.getTransaction().commit();

        }

    }
}
