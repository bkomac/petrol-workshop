package si.petrol.workshop.market.api.rest.v1.mappers;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import si.petrol.workshop.market.lib.common.ApiError;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class ResourceNotFoundMapper implements ExceptionMapper<ResourceNotFoundException>{

    private static final Logger logger = LogManager.getLogger(ResourceNotFoundMapper.class.getName());

    @Override
    public Response toResponse(ResourceNotFoundException exception) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(Response.Status.NOT_FOUND.getStatusCode());
        error.setCode("resource.not.found");
        error.setMessage(exception.getMessage());

        logger.trace(exception);

        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(error).build();
    }
}
