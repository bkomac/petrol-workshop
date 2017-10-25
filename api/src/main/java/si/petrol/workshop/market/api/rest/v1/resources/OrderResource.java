package si.petrol.workshop.market.api.rest.v1.resources;

import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.CartItem;
import si.petrol.workshop.market.lib.Order;
import si.petrol.workshop.market.services.CartService;
import si.petrol.workshop.market.services.OrderService;
import si.petrol.workshop.market.services.exceptions.MarketException;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.smartcardio.CardException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/orders")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    private OrderService orderService;

    @GET
    @Path("/{id}")
    public Response getCart(@PathParam("id") String id) {

        Order order = orderService.findOrderById(id);
        return Response.ok(order).build();
    }

    @POST
    public Response createOrder(Order order) throws CardException, MarketException, ResourceNotFoundException {

        Order order2 = orderService.createOrder(order);
        return Response.status(Response.Status.CREATED).entity(order2).build();
    }

    @POST
    @Path("/{id}/complete")
    public Response completeOrder(@PathParam("id") String id) {

        Order order = orderService.completeOrder(id);
        return Response.status(Response.Status.ACCEPTED).entity(order).build();
    }

    @POST
    @Path("/{id}/cancel")
    public Response cancelOrder(@PathParam("id") String id) {

        Order order = orderService.cancelOrder(id);
        return Response.status(Response.Status.ACCEPTED).entity(order).build();
    }

}
