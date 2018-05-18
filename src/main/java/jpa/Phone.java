package jpa;

import javax.persistence.*;

/**
 * Created by Solidbeans on 2017-03-27.
 */


@Entity
public class Phone {
    @Id
    @GeneratedValue
    private long id;
    private String make;

    @ManyToOne(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="OWNER_ID")
    private Employee owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", owner=" + owner +
                '}';
    }
}
