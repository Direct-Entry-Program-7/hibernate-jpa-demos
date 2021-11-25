package lk.ijse.dep7;

import lk.ijse.dep7.entity.Bill;
import lk.ijse.dep7.entity.BillDetail;
import lk.ijse.dep7.entity.Item;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo7 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Bill b001 = session.find(Bill.class, "B001");
            b001.getBillDetailList().forEach(System.out::println);

            session.getTransaction().commit();

        }

    }
}
