package lk.ijse.dep7;

import lk.ijse.dep7.entity.Actor;
import lk.ijse.dep7.entity.Customer;
import lk.ijse.dep7.entity.Movie;
import lk.ijse.dep7.entity.Order;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class ManyToManyDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Actor a001 = new Actor("A001", "Dinusha");
            Actor a002 = new Actor("A002", "Sovis");
            Actor a003 = new Actor("A003", "Pethum");
            Actor a004 = new Actor("A004", "Manoj");

            Movie m001 = new Movie("M001", "Iron Man");
            Movie m002 = new Movie("M002", "Dune");
            Movie m003 = new Movie("M003", "Ant Man");
            Movie m004 = new Movie("M004", "Sky Fall");

            a001.getMovieList().add(m003);
            a001.getMovieList().add(m004);

            a002.getMovieList().add(m002);
            a002.getMovieList().add(m004);

            a003.getMovieList().add(m001);
            a003.getMovieList().add(m003);

            a004.getMovieList().add(m002);

            session.persist(a001);
            session.persist(a002);
            session.persist(a003);
            session.persist(a004);

            session.getTransaction().commit();

        }

    }
}
