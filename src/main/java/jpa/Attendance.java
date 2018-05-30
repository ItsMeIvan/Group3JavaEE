package jpa;


import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NamedQuery(name="AttendanceFindByCourseAndUser", query ="SELECT a FROM Attendance a WHERE a.student = :student and " +
        "a.course = :course")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean presence;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

    public Attendance(){}

    public Attendance(Date date, boolean presence, Course course, Student student) throws ParseException {
        this.date = date;
        this.presence = presence;
        this.course = course;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



}
