package lk.ijse.dep7;

import lk.ijse.dep7.entity.Gender;
import lk.ijse.dep7.entity.MarriedStatus;
import lk.ijse.dep7.entity.Teacher;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EnumDemo {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            session.beginTransaction();

//            Teacher teacher = new Teacher(1, "Dulanga", "Matara", "077-1234567", Gender.MALE, MarriedStatus.MARRIED);
//            session.persist(teacher);

            Teacher teacher = session.get(Teacher.class, 1);
            teacher.setMarriedStatus(MarriedStatus.UNMARRIED);

            session.getTransaction().commit();
        }

    }
}
