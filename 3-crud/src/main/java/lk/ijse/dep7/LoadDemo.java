package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            // Lazy Fetching
            Student student = session.load(Student.class, 1);
            System.out.println(student.getId()); // 1
            System.out.println(student.getName());  // SELECT name
            System.out.println(student.getAddress());   // address
            System.out.println("Is student inside the context: " + session.contains(student));

//            // Eager Fetching
//            Student student1 = session.get(Student.class, 25);
//            System.out.println(student.getId());

        }

    }
}
