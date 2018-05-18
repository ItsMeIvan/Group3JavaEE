package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-26.
 */
public class MainOneToOne {
    static EntityManager em;
    static List<Employee> employee;
    static List<AddressRel> addressRel;
    static EntityManagerFactory emFactory ;
    static long addId;

    public static void main(String[] args) {

        emFactory = Persistence.createEntityManagerFactory("jpa-example");

        create();

    }

    public static void create(){
        em = emFactory.createEntityManager();

        em.getTransaction().begin();

        AddressRel a1 = new AddressRel();
        a1.setStreet("Street 1");
        a1.setTown("Town 1");
        em.persist(a1);
        AddressRel a2 = new AddressRel();
        a2.setStreet("Street 2");
        a2.setTown("Town 2");
        em.persist(a2);

        Employee e1 = new Employee();
        e1.setName("Employee 1");
        e1.setAddressrel(a1);
        em.persist(e1);

        Employee e2 = new Employee();
        e2.setName("Employee 2");
        e2.setAddressrel(a1);
        em.persist(e2);

        em.getTransaction().commit();

        em.getTransaction().begin();
        e2.setName("E 2");
        a2.setCountry("Country");
        em.merge(e2);

        em.getTransaction().commit();
        em.close();
    }

}