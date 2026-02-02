package ee.valiit.catmanager.infrastructure.error;

import lombok.Getter;

@Getter
public enum Error {
INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
USER_NOT_FOUND("Kasutajat ei leitud", 112),
USERNAME_ALREADY_EXISTS ("Kasutajanimi on juba olemas", 113),
EMAIL_ALREADY_EXISTS ("Selle emailiga kasutaja on juba registreeritud", 114);

private final String message;
private final Integer errorCode;

    Error(String message, Integer errorCode) {
        this.message=message;
        this.errorCode=errorCode;
    }
}
