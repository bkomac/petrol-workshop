package si.petrol.workshop.market.api.rest.v1.mappers;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import si.petrol.workshop.market.api.rest.v1.beans.ExtendedStatus;
import si.petrol.workshop.market.lib.common.ApiError;
import si.petrol.workshop.market.services.exceptions.MarketValidationException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

/**
 *
 * @author Tilen Faganel
 * @since 1.0.0
 */
@Provider
@ApplicationScoped
public class ValidationFailedMapper implements ExceptionMapper<MarketValidationException> {

    private static final Logger logger = LogManager.getLogger(ValidationFailedMapper.class.getName());

    @Override
    public Response toResponse(MarketValidationException e) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(422);
        error.setCode("validation.failed");
        error.setErrors(e.getErrors());

        error.getErrors().forEach(er -> er.setCode("validation.constraints." + er.getCode()));

        logger.trace(e);

        return Response
                .status(ExtendedStatus.UNPROCESSABLE_ENTITY)
                .entity(error).build();
    }
}