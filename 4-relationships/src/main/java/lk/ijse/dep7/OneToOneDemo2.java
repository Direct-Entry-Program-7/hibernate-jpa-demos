package lk.ijse.dep7;

import lk.ijse.dep7.entity.Employee;
import lk.ijse.dep7.entity.Spouse;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Spouse s001 = session.get(Spouse.class, "S001");
            Employee e001 = session.get(Employee.class, "E001");
            Employee e003 = session.get(Employee.class, "E003");

            System.out.println(s001.getEmployee());
//            s001.setEmployee(e003);

            e001.setSpouse(s001);


            session.getTransaction().commit();

        }

    }
}
