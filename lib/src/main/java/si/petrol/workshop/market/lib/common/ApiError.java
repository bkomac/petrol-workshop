package si.petrol.workshop.market.lib.common;

import java.util.List;
import java.util.UUID;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class ApiError {

    private UUID ref;
    private Integer status;
    private String code;
    private String message;
    private String moreInfo;
    private List<ValidationError> errors;

    public UUID getRef() {
        return ref;
    }

    public void setRef(UUID ref) {
        this.ref = ref;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }
}
