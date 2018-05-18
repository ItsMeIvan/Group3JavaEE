package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Solidbeans on 2017-03-27.
 */
public class MainOneToMany {
    static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example2");
        em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Employee e1 = new Employee();
        e1.setName("Employee 1");

        em.persist(e1);

        Phone p1 = new Phone();
        p1.setMake("Motorola");
        p1.setOwner(e1);
        em.persist(p1);

        Phone p2 = new Phone();
        p2.setMake("Nokia");
        p2.setOwner(e1);
        em.persist(p2);

        em.getTransaction().commit();



        Employee e2 = em.find(Employee.class,1L);

        em.refresh(e2);

        System.out.println(e2.getName());
        System.out.println("Phones: " + e2.getPhones().size());
        for (Phone p:e2.getPhones()) {
            Employee e3 = p.getOwner();
            System.out.println(p.getMake() + " Owner " + p.getOwner().getName());
            System.out.println(p.getMake() + " Owners Phones " + p.getOwner().getPhones());
        }
        em.close();
    }
}
