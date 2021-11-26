package lk.ijse.dep7;

import lk.ijse.dep7.entity.Parent;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

public class ReadBlob {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            session.beginTransaction();

            Parent parent = session.get(Parent.class, 2);

            Path path = Paths.get("/home/ranjith-suranga/Desktop/output/chandima-picture.png");
//            Files.write(path, parent.getPicture());
            Files.write(path, parent.getPicture().getBytes(1, (int) parent.getPicture().length()));

            session.getTransaction().commit();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to write the picture");
        }

    }

}
