package jsf;

import domain.CourseDomain;
import ejb.CourseService;
import ejb.CourseServiceImpl;
import ejb.LoginService;
import ejb.StudentService;
import jpa.Course;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class RegisterForCourseBean {
    private List<CourseDomain> courses;

    @EJB
    CourseService courseService;
    @EJB
    LoginService loginService;

    public List<CourseDomain> getCourses() {
        return courseService.getCourses();
    }

    public void setCourses(List<CourseDomain> courses) {
        this.courses = courses;
    }

    public void unRegisterCourse(CourseDomain c, Long studentId){
        courseService.unregisterCourse(c, studentId);



    }
}
