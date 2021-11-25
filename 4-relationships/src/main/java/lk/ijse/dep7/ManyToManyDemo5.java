package lk.ijse.dep7;

import lk.ijse.dep7.entity.*;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Item i001 = new Item("I001", "Keyboard", 10, new BigDecimal("500"));
            Item i002 = new Item("I002", "Mouse", 10, new BigDecimal("450"));
            Item i003 = new Item("I003", "Hand free", 10, new BigDecimal("500"));
            Item i004 = new Item("I004", "Sub-woofer", 10, new BigDecimal("150"));

            Bill b001 = new Bill("B001", Date.valueOf("2021-11-20"));
            Bill b002 = new Bill("B002", Date.valueOf("2021-11-20"));

            BillDetail bd001 = new BillDetail(new BillDetailPK("I001", "B001"), 2, new BigDecimal("500"), i001, b001);
            BillDetail bd002 = new BillDetail(new BillDetailPK("I002", "B001"), 2, new BigDecimal("450"), i002, b001);
            BillDetail bd003 = new BillDetail(new BillDetailPK("I002", "B002"), 1, new BigDecimal("450"), i002, b002);
            BillDetail bd004 = new BillDetail(new BillDetailPK("I003", "B002"), 1, new BigDecimal("500"), i003, b002);

            session.persist(bd001);
            session.persist(bd002);
            session.persist(bd003);
            session.persist(bd004);
            session.persist(i004);

            session.getTransaction().commit();

        }

    }
}
