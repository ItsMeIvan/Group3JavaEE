package ejb;

import domain.CourseDomain;
import jpa.Course;

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
    public void generateCourses() {

        Course c1 = new Course("Java SE");
        Course c2 = new Course("Webb");
        Course c3 = new Course("Math");
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);


    }
}
