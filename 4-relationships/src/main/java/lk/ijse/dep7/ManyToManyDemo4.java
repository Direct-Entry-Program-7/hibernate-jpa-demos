package lk.ijse.dep7;

import lk.ijse.dep7.entity.Actor;
import lk.ijse.dep7.entity.Movie;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo4 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Actor a001 = session.get(Actor.class, "A001");
            Actor a003 = session.get(Actor.class, "A003");
            Actor a005 = new Actor("A005", "Dulanga");

            List<Actor> actors =new ArrayList<>();
            Movie movie = new Movie("M005", "Kill Bill", actors);
            actors.add(a001);
            actors.add(a003);
            actors.add(a005);

            session.persist(movie);

            session.getTransaction().commit();

        }

    }
}
