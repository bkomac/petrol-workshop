package si.petrol.workshop.market.lib.common;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public enum ValidationErrorCode {

    DecimalMax("DecimalMax"),
    DecimalMin("DecimalMin"),
    Digits("Digits"),
    Email("Email"),
    Future("Future"),
    Max("Max"),
    Min("Min"),
    Negative("Negative"),
    NotBlank("NotBlank"),
    NotEmpty("NotEmpty"),
    NotNull("NotNull"),
    Null("Null"),
    Past("Past"),
    Pattern("Pattern"),
    Positive("Positive"),
    Size("Size"),

    Unknown("");

    private String code;

    ValidationErrorCode(String code) {
        this.code = code;
    }

    public static ValidationErrorCode findByCode(String code) {

        for (ValidationErrorCode errorCode : values()) {

            if (errorCode.getCode().equals(code)) {
                return errorCode;
            }
        }

        return Unknown;
    }

    public String getCode() {
        return code;
    }
}
