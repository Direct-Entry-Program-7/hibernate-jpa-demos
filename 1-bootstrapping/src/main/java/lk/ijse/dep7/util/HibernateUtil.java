package lk.ijse.dep7.util;

import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        return null;
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
