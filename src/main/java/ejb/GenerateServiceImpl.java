package ejb;

import domain.CourseDomain;
import jpa.Course;
import jpa.Student;
import jpa.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class GenerateServiceImpl implements GenerateService {
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    @Override
    public void generateData() {

        Student s1 = new Student("Ivan","Saric","is@mail.com","12345");
        Student s2 = new Student("Jon","Stone","js@mail.com","12345");
        em.persist(s1);
        em.persist(s2);


        Teacher t1 = new Teacher("Ann","Andreasson","aa@mail.com","12345");
        Teacher t2 = new Teacher("Boris","Yang","by@mail.com","12345");
        em.persist(t1);
        em.persist(t2);



        Course c1 = new Course("Java SE");
        Course c2 = new Course("Webb");
        Course c3 = new Course("Math");

        s1.addCourses(c1);
        t1.addCourses(c1);
        em.persist(c1);

        s1.addCourses(c2);
        s2.addCourses(c2);
        t1.addCourses(c2);
        em.persist(c2);

        s2.addCourses(c3);
        t2.addCourses(c3);
        em.persist(c3);

    }
}
