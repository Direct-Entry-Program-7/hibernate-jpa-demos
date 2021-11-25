package lk.ijse.dep7;

import lk.ijse.dep7.entity.Actor;
import lk.ijse.dep7.entity.Movie;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo3 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Movie m001 = session.find(Movie.class, "M001");
            m001.getActorList().forEach(System.out::println);

            Actor a002 = session.find(Actor.class, "A002");

            m001.removeActor(a002);
//            m001.addActor(a002);

//            List<Actor> actorList = new ArrayList<>();
//            actorList.addAll(m001.getActorList());
//            actorList.add(a002);
//
//            m001.setActorList(actorList);

            session.getTransaction().commit();

        }

    }
}
