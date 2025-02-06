package fr.sdv;

import fr.sdv.entites.Client;
import fr.sdv.entites.Emprunt;
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
            //System.out.println(livre);
        }

        Emprunt emprunt = entityManager.find(Emprunt.class, 1);
        if (emprunt != null) {
            System.out.println(emprunt.getLivres());
        }

        Client client = entityManager.find(Client.class, 1);
        if (client != null) {
            System.out.println(client.getEmprunts());
        }

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
