package id.nano.controller;

import id.nano.model.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {
    @Inject
    EntityManager entityManager;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getSubordinates(@QueryParam("idnumber") Integer idNumber) {
        String script = "WITH RECURSIVE bawahan AS (SELECT id,name,manager_id FROM employee WHERE id = :id UNION SELECT e.id, e.name, e.manager_id FROM employee e INNER JOIN bawahan s ON s.id = e.manager_id) SELECT a.id, a.name, a.manager_id, b.score FROM bawahan a left join employee_score b on a.id = b.id";
        Query query = entityManager.createNativeQuery(script, Employee.class);
        query.setParameter("id", idNumber);
        return query.getResultList();
    }

    @Path("/avg")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAvg(@QueryParam("idnumber") Integer idNumber) {
        String script = "WITH RECURSIVE bawahan AS (SELECT id,name,manager_id FROM employee WHERE id = :id UNION SELECT e.id, e.name, e.manager_id FROM employee e INNER JOIN bawahan s ON s.id = e.manager_id) SELECT avg(b.score) FROM bawahan a left join employee_score b on a.id = b.id";
        Query query = entityManager.createNativeQuery(script, Employee.class);
        query.setParameter("id", idNumber);
        return query.getResultList();
    }
}
