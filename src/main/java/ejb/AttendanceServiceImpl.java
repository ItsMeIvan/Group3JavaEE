package ejb;

import jpa.Attendance;
import jpa.Course;
import jpa.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AttendanceServiceImpl implements AttendanceService {

    @PersistenceContext
    EntityManager em;

    @Override
    public StringBuilder getAttendanceStatistics(Long courseId, Long studentId) {
        StringBuilder statistic = new StringBuilder("Never been a student of the course");

        Student student = em.find(Student.class, studentId);
        Course course = em.find(Course.class, courseId);
        Query query = em.createNamedQuery("AttendanceFindByCourseAndUser");
        query.setParameter("student", student);
        query.setParameter("course", course);

        List<Attendance> list = query.getResultList();
        if (list.size()>0) {
            double presence = 0.0d;
            for (Attendance a: list) {
                if(a.isPresence())
                {
                    presence++;
                }
            }

            double totalAttendance = presence/list.size() * 100;
            statistic.setLength(0);
            statistic.append(totalAttendance).setLength(statistic.indexOf("."));
            statistic.append("%");

        }
        return statistic;
    }
}
