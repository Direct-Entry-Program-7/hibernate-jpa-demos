package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.entity.Teacher;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class SaveDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            /* With save() you can specify an id for the auto generated primary key but
               it doesn't matter because it is going to ignore it anyway */
//            Teacher sovis = new Teacher(10,"Sovis", "077-456789123");
//            System.out.println(sovis);
//            Serializable id = session.save(sovis);
//            System.out.println(sovis);
//            System.out.println(id);
//            System.out.println("Is Sovis inside the cache? " + session.contains(sovis));

            /* With persist() you can't specify an id for the auto generated primary key */
            Teacher dinusha = new Teacher(10, "Dinusha", "077-456789123");
            System.out.println(dinusha);
            session.persist(dinusha);
            System.out.println(dinusha);
            System.out.println("Is dinusha inside the cache? " + session.contains(dinusha));

            session.getTransaction().commit();

        }

    }
}
