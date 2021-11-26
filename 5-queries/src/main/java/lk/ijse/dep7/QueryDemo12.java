package lk.ijse.dep7;

import lk.ijse.dep7.entity.CustomEntity;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QueryDemo12 {

    public static void main(String[] args) {

        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {

            session.beginTransaction();

            /* HQL Join Queries */

//            List<Object[]> employeeDetailList = session.createQuery("SELECT e.id, e.name, e.address, s.name as spouseName FROM Employee e INNER JOIN Spouse s WITH e.id = s.employee.id").list();
//            employeeDetailList.forEach(System.out::println);

//            List<CustomEntity> employeeDetailList = session.createQuery("SELECT new lk.ijse.dep7.entity.CustomEntity(e.id, e.name, e.address, s.name) FROM Employee e INNER JOIN Spouse s WITH e.id = s.employee.id").list();
//            List<CustomEntity> employeeDetailList = session.createQuery("SELECT new lk.ijse.dep7.entity.CustomEntity(e.id, e.name, e.address, s.name) FROM Employee e INNER JOIN Spouse s WITH e.id = s.employee").list();
//            List<CustomEntity> employeeDetailList = session.createQuery("SELECT new lk.ijse.dep7.entity.CustomEntity(e.id, e.name, e.address, s.name) FROM Employee e INNER JOIN Spouse s WITH e = s.employee.id").list();
//            List<CustomEntity> employeeDetailList = session.createQuery("SELECT new lk.ijse.dep7.entity.CustomEntity(e.id, e.name, e.address, s.name) FROM Employee e INNER JOIN Spouse s WITH e = s.employee").list();
//            List<CustomEntity> employeeDetailList = session.createQuery("SELECT new lk.ijse.dep7.entity.CustomEntity(e.id, e.name, e.address, s.name) FROM Employee e INNER JOIN e.spouse s").list();
            List<CustomEntity> employeeDetailList = session.createQuery("SELECT new lk.ijse.dep7.entity.CustomEntity(e.id, e.name, e.address, s.name) FROM Spouse s INNER JOIN s.employee e").list();
            employeeDetailList.forEach(System.out::println);

            session.getTransaction().commit();

        }

    }
}
