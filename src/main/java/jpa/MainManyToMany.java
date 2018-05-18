package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Solidbeans on 2017-03-27.
 */
public class MainManyToMany {
    static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example2");
        em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Employee e1 = new Employee();
        e1.setName("Employee 1");
        em.persist(e1);

        Project pr1 = new Project();
        pr1.setName("Proj 1");

        em.persist(pr1);
        Project pr2 = new Project();
        pr2.setName("Proj 2");

        em.persist(pr2);

        e1.addProjects(pr1);
        e1.addProjects(pr2);

        em.getTransaction().commit();


        em.close();
    }
}
