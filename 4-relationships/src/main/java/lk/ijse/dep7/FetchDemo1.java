package lk.ijse.dep7;

import lk.ijse.dep7.entity.Actor;
import lk.ijse.dep7.entity.Movie;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class FetchDemo1 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Movie m001 = session.get(Movie.class, "M001");
            System.out.println(m001.getName());
            //System.out.println(m001.getActorList().size());

            session.getTransaction().commit();

        }

    }
}
