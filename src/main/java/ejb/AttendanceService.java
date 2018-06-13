package ejb;

import domain.StudentDomain;
import jpa.Course;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AttendanceService {
    StringBuilder getAttendanceStatistics(Long courseId, Long studentId);
    void saveAttendances(List<StudentDomain> students, Long currentCourseId);
}
