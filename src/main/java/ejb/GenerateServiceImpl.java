package ejb;

import domain.CourseDomain;
import jpa.Attendance;
import jpa.Course;
import jpa.Student;
import jpa.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        //Date sparas some 1970-01.01 i databasen
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date(2017-05-03);
        Date d2 = new Date(2017-05-04);
        Date d3 = new Date(2017-05-05);

        Attendance a1 = new Attendance(d1, false, c1, s1);
        Attendance a2 = new Attendance(d1, false, c2, s1);
        Attendance a3 = new Attendance(d2, true, c1, s1);
        Attendance a4 = new Attendance(d2, true, c2, s1);
        Attendance a5 = new Attendance(d3, true, c1, s1);
        Attendance a6 = new Attendance(d3, false, c2, s1);

        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        em.persist(a4);
        em.persist(a5);
        em.persist(a6);

    }
}
