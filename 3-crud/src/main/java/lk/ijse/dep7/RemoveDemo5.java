package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.entity.Teacher;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class RemoveDemo5 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Teacher chandima = session.get(Teacher.class, 2);
            session.remove(chandima);
            System.out.println(chandima);
            session.persist(chandima);
            System.out.println(chandima);
//            Serializable id = session.save(chandima);
//            System.out.println(id);
//            System.out.println(chandima);

            session.getTransaction().commit();

        }

    }
}
