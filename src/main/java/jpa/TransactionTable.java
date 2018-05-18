package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Solidbeans on 2017-03-26.
 */
@Entity
public class TransactionTable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public TransactionTable() {
    }

    public TransactionTable(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}