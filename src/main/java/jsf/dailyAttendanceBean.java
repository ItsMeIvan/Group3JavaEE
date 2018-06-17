package jsf;

import domain.CourseDomain;
import domain.StudentDomain;
import ejb.AttendanceService;
import ejb.CourseService;
import ejb.StudentService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class dailyAttendanceBean {
    private List<StudentDomain> students;
    private List<CourseDomain> courses;

    @EJB
    StudentService studentService;

    @EJB
    CourseService courseService;

    @EJB
    AttendanceService attendanceService;

    public List<StudentDomain> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDomain> students) {
        this.students = students;
    }

    public List<CourseDomain> getCourses() {
        return courses = courseService.getCourses();
    }

    public void setCourses(List<CourseDomain> courses) {
        this.courses = courses;
    }
}
