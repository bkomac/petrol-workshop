package si.petrol.workshop.market.api.rest.v1.resources;

import si.petrol.workshop.market.lib.Customer;
import si.petrol.workshop.market.services.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerService custService;

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") String id){

        Customer cust = custService.findCustomerById(id);

        return Response.ok(cust).build();

    }

    @POST
    public Response createCustomer(Customer newCustomer) {

        Customer cust = custService.createCustomer(newCustomer);

        return Response.status(Response.Status.CREATED).entity(cust).build();
    }

}
