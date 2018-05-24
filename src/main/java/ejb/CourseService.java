package ejb;

import domain.CourseDomain;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CourseService {
    void addCourse(CourseDomain course);
    void updateCourse(CourseDomain person);
    CourseDomain getCourse(Long id);
    void removeCourse(Long id);
    List<CourseDomain> getCourses();
}
