package fr.sdv;

import fr.sdv.entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Livre livre = entityManager.find(Livre.class, 1);
        if (livre != null) {
            System.out.println(livre);
        }

        entityManager.getTransaction().commit();
    }
}
