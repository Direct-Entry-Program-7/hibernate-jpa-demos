package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            // SELECT, SELECT, Student{1,Sovis}

            Student student = session.get(Student.class, 1);
            session.detach(student);
            student.setName("Cisco");
            session.refresh(student);
            System.out.println(student);

            session.getTransaction().commit();

        }

    }
}
