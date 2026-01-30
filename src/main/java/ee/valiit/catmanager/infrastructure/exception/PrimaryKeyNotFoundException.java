package ee.valiit.catmanager.infrastructure.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;


@Getter
public class PrimaryKeyNotFoundException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public PrimaryKeyNotFoundException(String fieldName, Integer fieldValue) {
        super("Ei leidnud primary keyd '" + fieldName + "' väärtusega: " + fieldValue);
        this.message = "Ei leidnud primary keyd '" + fieldName + "' väärtusega: " + fieldValue;
        this.errorCode = 777;
    }
}
