package org.learn.Jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Alien alien = new Alien();
        alien.setAid(100);
        alien.setAname("Aswin");

        entityManager.getTransaction().begin();
        entityManager.persist(alien);

        Alien a1 = entityManager.find(Alien.class, 100);
        System.out.println(a1.getAname());
        entityManager.getTransaction().commit();
    }
}
