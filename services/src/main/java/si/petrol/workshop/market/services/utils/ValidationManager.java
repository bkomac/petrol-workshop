package si.petrol.workshop.market.services.utils;

import si.petrol.workshop.market.lib.common.ValidationError;
import si.petrol.workshop.market.lib.common.ValidationErrorCode;
import si.petrol.workshop.market.services.exceptions.MarketValidationException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
@ApplicationScoped
public class ValidationManager {

    private Validator validator;

    @PostConstruct
    private void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

//    public void validateEntity(BaseEntity entity) {
//
//        Set<ConstraintViolation<BaseEntity>> errors = validator.validate(entity);
//
//        if (!errors.isEmpty()) {
//
//            List<ValidationError> validationErrors = new ArrayList<>();
//
//            for (ConstraintViolation<BaseEntity> c : errors) {
//
//                Annotation annotation = c.getConstraintDescriptor().getAnnotation();
//
//                ValidationError ve = new ValidationError();
//                ve.setField(c.getPropertyPath().toString());
//                ve.setCode(annotation.annotationType().getSimpleName());
//
//                validationErrors.add(ve);
//            }
//
//            throw new MarketValidationException(validationErrors);
//        }
//    }

    public void validateMin(BigDecimal value, BigDecimal min, String field) {

        if (value.compareTo(min) < 0) {

            ValidationError ve = new ValidationError();
            ve.setField(field);
            ve.setCode(ValidationErrorCode.Min.getCode());

            throw new MarketValidationException(Collections.singletonList(ve));
        }
    }

    public void validateNotNull(Object value, String field) {

        if (value == null) {

            ValidationError ve = new ValidationError();
            ve.setField(field);
            ve.setCode(ValidationErrorCode.NotNull.getCode());

            throw new MarketValidationException(Collections.singletonList(ve));
        }
    }
}
