package lk.ijse.dep7;

import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

//            Order od001 = session.get(Order.class, "OD001");
//            Customer c003 = session.get(Customer.class, "C003");
//            System.out.println(od001);
//            od001.setCustomer(c003);

            Customer c001 = session.get(Customer.class, "C001");
            c001.getOrderList().forEach(System.out::println);

            Order od001 = session.get(Order.class, "OD001");
            System.out.println(od001.getCustomer());

            List<Order> orders = new ArrayList<>();
            orders.addAll(c001.getOrderList());
            orders.add(od001);

            c001.setOrderList(orders);

            session.getTransaction().commit();

        }

    }
}
