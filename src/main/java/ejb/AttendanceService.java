package ejb;

import jpa.Course;

import javax.ejb.Remote;

@Remote
public interface AttendanceService {
    StringBuilder getAttendanceStatistics(Long courseId, Long studentId);
}
