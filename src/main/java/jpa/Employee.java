package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-26.
 */

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToOne(fetch= FetchType.LAZY,cascade = CascadeType.MERGE)
    private AddressRel addressrel;


    @OneToMany(mappedBy = "owner")
    private List<Phone> phones;


    @ManyToMany(fetch= FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinTable(
            name="EMP_PROJ",
            joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="PROJ_ID", referencedColumnName="ID"))
    private List<Project> projects;

    public Employee() {
    }

    public Employee(String name, AddressRel addressrel) {
        this.name = name;
        this.addressrel = addressrel;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressRel getAddressrel() {

        return addressrel;
    }

    public void setAddressrel(AddressRel addressrel) {

        this.addressrel = addressrel;
    }

    public List<Project> getProjects() {
        if ( projects == null )
            projects = new ArrayList<>();
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProjects(Project project) {
        if ( projects == null )
            projects = new ArrayList<>();
        this.projects.add(project);
    }
}
