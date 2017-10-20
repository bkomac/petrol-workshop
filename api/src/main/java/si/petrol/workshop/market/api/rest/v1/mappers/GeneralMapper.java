package si.petrol.workshop.market.api.rest.v1.mappers;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import si.petrol.workshop.market.lib.common.ApiError;

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
public class GeneralMapper implements ExceptionMapper<Exception> {

    private static final Logger logger = LogManager.getLogger(GeneralMapper.class.getName());

    @Override
    public Response toResponse(Exception exception) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(500);
        error.setCode("internal.error");

        logger.error(exception);

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(error).build();
    }
}
