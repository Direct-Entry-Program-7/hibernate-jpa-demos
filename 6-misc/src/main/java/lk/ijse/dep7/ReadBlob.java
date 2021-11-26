package lk.ijse.dep7;

import lk.ijse.dep7.entity.Gender;
import lk.ijse.dep7.entity.MarriedStatus;
import lk.ijse.dep7.entity.Parent;
import lk.ijse.dep7.entity.Teacher;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadBlob {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            session.beginTransaction();

            Parent parent = session.get(Parent.class, 1);

            Path path = Paths.get("/home/ranjith-suranga/Desktop/output/pethum-picture.jpeg");
            Files.write(path, parent.getPicture());

            session.getTransaction().commit();
        } catch (IOException e) {
            System.out.println("Failed to write the picture");
        }

    }

}
