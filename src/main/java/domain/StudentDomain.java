package domain;

import jpa.Attendance;
import jpa.Course;

import java.util.List;

public class StudentDomain {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private List<Course> courses;
    private List<Attendance> attendances;
    private Boolean presence = false;

    public StudentDomain() {
    }

    public StudentDomain(Long id, String firstname, String lastname, String email, String password, List<Course> courses, List<Attendance> attendances) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.courses = courses;
        this.attendances = attendances;
    }

    public StudentDomain(String firstname, String lastname, String email, String password, List<Course> courses, List<Attendance> attendances) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.courses = courses;
        this.attendances = attendances;
    }

    public StudentDomain(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public StudentDomain(Long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public Boolean getPresence() {
        return presence;
    }

    public void setPresence(Boolean presence) {
        this.presence = presence;
    }
}

