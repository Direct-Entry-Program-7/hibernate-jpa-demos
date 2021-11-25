package lk.ijse.dep7;

import lk.ijse.dep7.entity.Bill;
import lk.ijse.dep7.entity.BillDetail;
import lk.ijse.dep7.entity.BillDetailPK;
import lk.ijse.dep7.entity.Item;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo6 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            List<BillDetail> billDetailList = new ArrayList<>();
            billDetailList.add(new BillDetail(null, "B001", 1, new BigDecimal("1000")));
            billDetailList.add(new BillDetail("I002", "B002", 1, new BigDecimal("1000")));

            Item i005 = new Item("I005", "Monitor", 5, new BigDecimal("1000"), billDetailList);

            session.persist(i005);

            session.getTransaction().commit();

        }

    }
}
