package lk.ijse.dep7;

import lk.ijse.dep7.entity.Gender;
import lk.ijse.dep7.entity.MarriedStatus;
import lk.ijse.dep7.entity.Teacher;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class IDGeneratingDemo {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            session.beginTransaction();

            for (int i = 0; i < 2; i++) {
                Teacher teacher = new Teacher("Sovis", "Moratuwa", "077-123457", Gender.MALE, MarriedStatus.MARRIED);
                session.save(teacher);
            }

            session.getTransaction().commit();
        }

    }

}
