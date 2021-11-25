package lk.ijse.dep7;

import lk.ijse.dep7.entity.Actor;
import lk.ijse.dep7.entity.Movie;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo2 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Actor a004 = session.get(Actor.class, "A004");
            a004.getMovieList().clear();

            session.getTransaction().commit();

        }

    }
}
