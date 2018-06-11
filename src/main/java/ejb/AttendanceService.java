package ejb;

import jpa.Course;

import javax.ejb.Local;

@Local
public interface AttendanceService {
    StringBuilder getAttendanceStatistics(Long courseId, Long studentId);
}
