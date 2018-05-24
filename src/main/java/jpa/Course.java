package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="selectAll",query="SELECT c FROM Course c")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @OneToMany(fetch = FetchType.LAZY) //Check what CascadeType is and if we need it
    private List<Attendance> attendances;

    @ManyToMany(fetch = FetchType.LAZY)
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

    public void setName(String name) {
        this.name = name;
    }
}

