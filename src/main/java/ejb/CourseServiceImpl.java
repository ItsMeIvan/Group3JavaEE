package ejb;

import domain.CourseDomain;
import jpa.Course;

import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CourseServiceImpl implements CourseService{

    @PersistenceContext
    EntityManager em;


    @Override
    public void addCourse(CourseDomain course) {

    }

    @Override
    public void updateCourse(CourseDomain person) {

    }

    @Override
    public CourseDomain getCourse(Long id) {
        return null;
    }

    @Override
    public void removeCourse(Long id) {

    }

    @Override
    public List<CourseDomain> getCourses() {


        List<Course> l = em.createNamedQuery("selectAll").getResultList();

        return l.stream().
                map(c->new CourseDomain(c.getId(),c.getName())).
                collect(Collectors.toList());
    }
}
