package id.nano.controller;

import id.nano.model.Factorial;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/factorial")
@Produces(MediaType.APPLICATION_JSON)
public class FactorialController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Factorial> getAll() {
        return  Factorial.listAll();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@QueryParam("number") Integer number) {
        if (number <=0)
            return Response.status(Response.Status.BAD_REQUEST).entity("Cek Parameter Nomor").build();

        Factorial factorial = new Factorial();
        int result = 1;

        for (int x = 1; x <= number ; x++) {
            result *= x;
        }
        factorial.n = number;
        factorial.factorial = result;
        factorial.persist();

        return Response.status(Response.Status.OK).entity(factorial).build();
    }
}
