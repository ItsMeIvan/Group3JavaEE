package jpagroup3;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Teacher_ID")
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE) //????
    private List<Attendance> attendances;


    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE) //????
    private List<Student> students;

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

    public void setName(String make) {
        this.name = name;
    }
}

