package si.petrol.workshop.market.lib.common;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class ValidationError {

    private String field;
    private String entity;
    private String code;
    private String message;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
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
}
