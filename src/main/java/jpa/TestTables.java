package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestTables {
    static EntityManager em;

    public static void main(String[] args){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example");
        em = emFactory.createEntityManager();



    }

}
