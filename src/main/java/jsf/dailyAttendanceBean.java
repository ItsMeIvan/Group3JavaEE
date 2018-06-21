package jsf;

import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.StudentDomain;
import ejb.AttendanceService;
import ejb.CourseService;
import ejb.StudentService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean
@SessionScoped
public class dailyAttendanceBean {
    private Long courseId;

    private List<StudentDomain> students;
    private List<CourseDomain> courses;
    private List<AttendanceDomain> attendances;
    private Set<Date> dateList;


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

    public List<AttendanceDomain> getAttendances() {
        return attendances;
    }



    public StringBuilder getDailyCourseAttendance(Long courseId, Date date){
        //Gör denna när dates skrivs upp först
//        return attendanceService.getAttendanceStatisticsByCourse(courseId, date);
        return null;
    }

    public void setAttendances(List<AttendanceDomain> attendances) {
        this.attendances = attendances;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void changeCurrentCourceId(Long courseId) {
        this.courseId = courseId;
    }

    public Set<Date> getDateList() {
        if(courseId != null)
            return dateList = attendanceService.getAttendanceDatesByCourse(courseId);
        else
            return null;
    }

    public void setDateList(Set<Date> dateList) {
        this.dateList = dateList;
    }
}
