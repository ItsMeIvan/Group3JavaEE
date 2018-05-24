package jsf;

import domain.CourseDomain;
import ejb.CourseService;
import ejb.CourseServiceImpl;
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

    public List<CourseDomain> getCourses() {
        return courseService.getCourses();
    }

    public void setCourses(List<CourseDomain> courses) {
        this.courses = courses;
    }
}
