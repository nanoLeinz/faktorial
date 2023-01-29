package id.nano.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Factorial extends PanacheEntity {
    @Column(name = "n")
    public Integer n;

    @Column(name = "factorial")
    public Integer factorial;
}
