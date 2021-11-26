package lk.ijse.dep7;

import lk.ijse.dep7.entity.CustomEntity;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;

public class QueryDemo10 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            /* Native Queries (SQL) */

//            List<Object[]> employeeDetailList = session.createNativeQuery("SELECT e.id, e.name, e.address, s.name as sname FROM employee e INNER JOIN spouse s on e.id = s.employee_id").list();
//            System.out.println("ID\t\t|Name\t|Address\t|Spouse's Name");
//            System.out.println("__\t\t|____\t|_______\t|_____________");
//            for (Object[] row : employeeDetailList) {
//                System.out.printf("%s\t|%s\t|%s\t|%s\n", row[0], row[1], row[2], row[3]);
//            }
//
//            System.out.println("-------------------------------");

            List<CustomEntity> employeeDetailList = session.createNativeQuery("SELECT e.id, e.name, e.address, s.name as spouseName FROM employee e INNER JOIN spouse s on e.id = s.employee_id")
                            .setResultTransformer(Transformers.aliasToBean(CustomEntity.class)).list();
           employeeDetailList.forEach(System.out::println);

            session.getTransaction().commit();

        }

    }
}
