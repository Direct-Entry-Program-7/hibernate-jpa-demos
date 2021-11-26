package lk.ijse.dep7.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Properties;

public class JpaUtil {

    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){

        Properties jpaProp = new Properties();
        try {
            jpaProp.load(JpaUtil.class.getResourceAsStream("/application.properties"));
            return Persistence.createEntityManagerFactory("default", jpaProp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
