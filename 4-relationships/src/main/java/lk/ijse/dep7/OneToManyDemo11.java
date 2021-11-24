package lk.ijse.dep7;

import lk.ijse.dep7.entity.*;
import lk.ijse.dep7.entity.Class;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo11 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Class dep = new Class("DEP", "Direct Entry Program");
            Class mad = new Class("MAD", "Mobile Application Developer");
            Student pethum = new Student("S001", "Pethum", "Galle");
            Student sovis = new Student("S002", "Sovis", "Moratuwa");
            Student gayal = new Student("S003", "Gayal", "Gampaha");

//            session.save(dep);
            session.save(mad);
//            session.save(pethum);
            session.save(sovis);
            session.save(gayal);

            ClassStudent cs01 = new ClassStudent(new ClassStudentPK("DEP", "S001"), Date.valueOf("2021-01-05"), dep, pethum);
            ClassStudent cs02 = new ClassStudent("DEP", "S002", Date.valueOf("2021-01-05"));
            session.persist(cs01);
            session.save(cs02);

            session.getTransaction().commit();

        }

    }
}
