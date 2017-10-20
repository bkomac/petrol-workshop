package si.petrol.workshop.market.api.rest.v1.resources;

import si.petrol.workshop.market.lib.Product;
import si.petrol.workshop.market.services.ProductService;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/products")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductService prodService;

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") String id){

        Product prod = prodService.findProduct(id);
        return Response.ok(prod).build();

    }

    @GET
    public Response getAllProducts(@QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset){

        List<Product> prods = prodService.findProductsAll(limit, offset);
        return Response.ok(prods).build();

    }

    @GET
    @Path("/count")
    public Response getAllProductsCount(){

        return null;

    }

    @POST
    public Response createProduct(Product newProduct) throws ResourceNotFoundException {

        Product prod = prodService.addProduct((newProduct));

        return Response.status(Response.Status.CREATED).entity(prod).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") String id){

        prodService.deleteProduct(id);
        return Response.noContent().build();

    }

}
