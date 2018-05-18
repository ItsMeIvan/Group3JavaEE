package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Created by Solidbeans on 2017-03-26.
 */

public class Transactions {
    static EntityManager em;
    public static void main(String[] args) {
        TransactionTable t1 = new TransactionTable("Transaction 1");
        TransactionTable t2 = new TransactionTable("Transaction 2");
        TransactionTable t3 = new TransactionTable("Transaction 3");

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example");
        em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t1);
            em.persist(t2);

            em.persist(t3);
    //        int x = 3/0;
            em.getTransaction().commit();
            System.out.println("Complete");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Rollback");
        }
    }
}
