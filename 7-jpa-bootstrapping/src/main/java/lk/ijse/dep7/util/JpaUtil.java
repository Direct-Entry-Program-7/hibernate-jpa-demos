package lk.ijse.dep7.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("dep7");
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
