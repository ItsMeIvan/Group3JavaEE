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
public class CheckAttendanceBean {
    private List<StudentDomain> students;
    private List<CourseDomain> courses;

    @EJB
    StudentService studentService;

    @EJB
    CourseService courseService;

    public List<StudentDomain> getStudents() {
        return studentService.getStudents();
    }

    public List<CourseDomain> getCourses() {
        LoginBean loginBean = new LoginBean();
        return courseService.getCoursesFromTeacher(loginBean.getId());
    }



}
