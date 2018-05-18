package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Solidbeans on 2017-04-25.
 */
public class MainOneToMany2 {

    static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example");
        em = emFactory.createEntityManager();

        em.getTransaction().begin();


        EmployeePhone e1 = new EmployeePhone();
        e1.setName("Employee x1");
        PhoneEmployee p1 = new PhoneEmployee();
        p1.setName("Motorola x");
        e1.addPhone(p1);

        em.persist(e1);

        em.getTransaction().commit();

        em.close();
    }
}