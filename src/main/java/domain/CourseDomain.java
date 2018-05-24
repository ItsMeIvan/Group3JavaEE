package domain;

import jpa.Attendance;
import jpa.Student;
import jpa.Teacher;

import java.util.List;

public class CourseDomain {

    private long id;
    private String name;

    private Teacher teacher;

    private List<Attendance> attendances;

    private List<Student> students;

    public CourseDomain(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseDomain(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
