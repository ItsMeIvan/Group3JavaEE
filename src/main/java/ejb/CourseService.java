package ejb;

import domain.CourseDomain;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CourseService {
    void addCourse(CourseDomain course);
    void updateCourse(CourseDomain course);
    CourseDomain getCourse(Long id);
    void removeCourse(Long id);
    List<CourseDomain> getCourses();
    void registerCourse(Long courseId, Long studentId);
    void unregisterCourse(Long course, Long studentId);
    StringBuilder checkRegister(Long courseId, Long studentId);
    List<CourseDomain> getCoursesFromTeacher(Long teacherId);
}
