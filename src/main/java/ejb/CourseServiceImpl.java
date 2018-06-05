package ejb;

import domain.CourseDomain;
import jpa.Course;
import jpa.Student;
import jpa.Teacher;

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
    public void updateCourse(CourseDomain course) {
        //Student student = em.find();
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

    @Override
    public void registerCourse(Long courseId, Long studentId) {
        Student student = em.find(Student.class, studentId);
        Course course = em.find(Course.class, courseId);
        student.addCourses(course);
    }

    @Override
    public void unregisterCourse(Long courseId, Long studentId) {
        Student student = em.find(Student.class, studentId);
        Course course = em.find(Course.class, courseId);
        student.removeCourse(course);
    }

    @Override
    public StringBuilder checkRegister(Long courseId, Long studentId) {
        StringBuilder register = new StringBuilder("Unregistered");
        Student student = em.find(Student.class, studentId);
        Course course = em.find(Course.class, courseId);
        if(student.getCourses().contains(course)){
            register.setLength(0);
            register.append("Registered");
        }
        return register;
    }

    @Override
    public List<CourseDomain> getCoursesFromTeacher(Long teacherId) {
        Teacher teacher = em.find(Teacher.class, teacherId);
        Query query = em.createNamedQuery("selectCoursesFromTeacher");
        query.setParameter("teacher", teacher);

        List<Course> lc = query.getResultList();
        return lc.stream().
                map(c->new CourseDomain(c.getId(),c.getName())).
                collect(Collectors.toList());
    }


}
