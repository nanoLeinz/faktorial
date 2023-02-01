package id.nano.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends PanacheEntity {
    @Column(length = 80)
    public String name;

    @Column(length = 2)
    public Integer manager_id;
}
