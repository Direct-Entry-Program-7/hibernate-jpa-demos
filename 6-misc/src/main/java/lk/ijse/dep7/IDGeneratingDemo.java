package lk.ijse.dep7;

import lk.ijse.dep7.entity.Gender;
import lk.ijse.dep7.entity.MarriedStatus;
import lk.ijse.dep7.entity.Parent;
import lk.ijse.dep7.entity.Teacher;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

public class IDGeneratingDemo {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            session.beginTransaction();

            Path path = Paths.get("/home/ranjith-suranga/Desktop/chandima.png");
//            Blob serialBlob = new SerialBlob(Files.readAllBytes(path));   (JPA)
            Blob picture = BlobProxy.generateProxy(Files.readAllBytes(path)); // Native Hibernate

//            for (int i = 0; i < 8; i++) {
                Teacher teacher = new Teacher("Sovis", "Moratuwa", "077-123457", Gender.MALE, MarriedStatus.MARRIED);
                Parent parent = new Parent("Chandima", "Galle", "011-1234567", picture);
                session.save(parent);
                session.save(teacher);
//            }

            session.getTransaction().commit();
        } catch (IOException e) {
            System.out.println("Failed to read the picture");
        }

    }

}
