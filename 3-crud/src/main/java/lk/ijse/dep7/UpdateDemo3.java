package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student sovis = session.get(Student.class, 1);
            session.detach(sovis);
            Student sovis2 = session.get(Student.class, 1);
            session.update(sovis);

            session.getTransaction().commit();

        }

    }
}
