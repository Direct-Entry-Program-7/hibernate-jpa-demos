package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student student = new Student(3, "Aruni", "Matara", "055-1234567");
            Student student2 = new Student(4, "Dinusha", "Kandy", "041-1234567");
            Student student3 = new Student(1, "Sovis", "Dehiwala", "077-1234567");
            session.save(student);
            session.save(student2);
            session.update(student3);
            System.out.println("Saved");        // Saved
            session.remove(student);
            System.out.println("Deleted");      // Deleted
            session.save(student);              // INSERT INTO, INSERT INTO, UPDATE, DELETE
            System.out.println("Saved");        // Saved

            session.getTransaction().commit();  // INSERT INTO

        }

    }
}
