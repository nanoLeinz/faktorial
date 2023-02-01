package id.nano.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_score")
public class EmployeeScore extends PanacheEntity {
    @Column(length = 80)
    public String name;

    @Column(length = 4)
    public Integer score;
}
