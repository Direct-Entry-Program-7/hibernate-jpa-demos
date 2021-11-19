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

            // transient x -> detach

//            Teacher dinusha = new Teacher(10, "Dinusha", "077-456789123");
//            System.out.println(dinusha);
//            session.persist(dinusha);
//            System.out.println(dinusha);
//            System.out.println("Is dinusha inside the cache? " + session.contains(dinusha));

//            Teacher aruni = new Teacher("Aruni", "011-1234567");
//            Teacher manoj = new Teacher("Manoj", "077-1234567");
//
//            session.save(aruni);
//            System.out.println("Aruni has been saved");
//            System.out.println(aruni);
//
//            session.persist(manoj);
//            System.out.println("Manoj has been saved");
//            System.out.println(manoj);
//
//            Student pethum = new Student(2, "Pethum", "Galle", "011-456789123");

            // transient/detach > detach
//            Student dinusha2 = new Student(3, "Dinusha", "Gampaha", "033-456789123");
//
//            session.save(pethum);
//            System.out.println("Pethum has been saved");
//            System.out.println(pethum);
//
//            session.persist(dinusha2);
//            System.out.println("Dinsuha has been saved");
//            System.out.println(dinusha2);

            // transient, detach -> detach
//            Student student = new Student(3, "Manoj", "Kandy", "011-1234567");
//            session.persist(student);
//            System.out.println("Manoj has been persisted");

            Student student = session.get(Student.class, 4);
            session.detach(student);
            // dinusha -> detach
            student.setId(5); // transient
            session.persist(student);

            session.getTransaction().commit();

        }

    }
}
