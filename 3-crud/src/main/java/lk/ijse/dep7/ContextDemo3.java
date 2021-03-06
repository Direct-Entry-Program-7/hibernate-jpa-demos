package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            // SELECT
            // SELECT
            // 2, SOVIS,
            // UPDATE

            // 1 => sovis
            // 2 => pethum

            Student student = session.get(Student.class, 1);
            session.evict(student);
            student.setId(2);
            Student cloned = (Student) session.merge(student);
            System.out.println(cloned);

            session.getTransaction().commit();

        }

    }
}
