package jpagroup3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestTables {
    static EntityManager em;

    public static void main(String[] args){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example2");
        em = emFactory.createEntityManager();

        

    }

}
