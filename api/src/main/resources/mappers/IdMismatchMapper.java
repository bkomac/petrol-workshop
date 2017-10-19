package mappers;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import si.petrol.workshop.market.lib.common.ApiError;
import si.petrol.workshop.market.services.exceptions.IdMismatchException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
@Provider
@ApplicationScoped
public class IdMismatchMapper implements ExceptionMapper<IdMismatchException> {

    private static final Logger logger = LogManager.getLogger(IdMismatchMapper.class.getName());

    @Override
    public Response toResponse(IdMismatchException exception) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(400);
        error.setCode("resource.id.mismatch");

        logger.trace(exception);

        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(error)
                .build();
    }
}
