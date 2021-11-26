package lk.ijse.dep7;

import lk.ijse.dep7.entity.Parent;
import lk.ijse.dep7.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class HelloJpa {

    public static void main(String[] args) {

        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Parent parent = new Parent("Dinusha Jayawardena", "Panadura", "123456", null);
            em.persist(parent);

            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            t.printStackTrace();
        }

        em.close();
        emf.close();
    }

}
