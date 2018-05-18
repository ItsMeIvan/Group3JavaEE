package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Solidbeans on 2017-04-25.
 */
@Entity
public class EmployeePhone {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneEmployee> phones;

    public void addPhone(PhoneEmployee phone){
        if (phones == null )
            phones = new ArrayList<>();

        phones.add(phone);
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

    public List<PhoneEmployee> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEmployee> phones) {
        this.phones = phones;
    }
}
