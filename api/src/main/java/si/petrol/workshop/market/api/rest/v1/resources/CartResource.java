package si.petrol.workshop.market.api.rest.v1.resources;

import si.petrol.workshop.market.lib.Cart;
import si.petrol.workshop.market.lib.CartItem;
import si.petrol.workshop.market.lib.Customer;
import si.petrol.workshop.market.lib.responses.CountWrapper;
import si.petrol.workshop.market.services.CartService;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/carts")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {

    @Inject
    private CartService cartService;

    @GET
    @Path("/{id}")
    public Response getCart(@PathParam("id") String id) {

        Cart cart = cartService.findCartById(id);
        return Response.ok(cart).build();

    }


    @POST
    public Response createCart() {

        Cart cart = cartService.createCart();

        return Response.status(Response.Status.CREATED).entity(cart).build();
    }

    @POST
    @Path("/{id}/items")
    public Response addItemToCart(@PathParam("id") String id, CartItem cartItem) throws Exception {

        Cart cart = cartService.addItemToCartById(cartItem, id);

        return Response.status(Response.Status.OK).entity(cart).build();
    }

    @DELETE
    @Path("/{cartId}/items/{itemId}")
    public Response addItemToCart(@PathParam("cartId") String cartId, @PathParam("itemId") String itemId) throws ResourceNotFoundException {

        Cart cart = cartService.removeItemFromCart(cartId, itemId);

        return Response.status(Response.Status.GONE).entity(cart).build();
    }

}
