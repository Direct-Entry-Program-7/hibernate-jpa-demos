package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo9 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Student shymali = new Student(5, "Shymali", "Panadura", "011-1234567");
            session.merge(shymali); // SELECT
            System.out.println("Is shymali inside the cache? " + session.contains(shymali));    // FALSE
            session.detach(shymali);
            session.refresh(shymali);   // SELECT
            System.out.println("Is shymali inside the cache? " + session.contains(shymali));

            session.getTransaction().commit();  // UPDATE

        }

    }
}
