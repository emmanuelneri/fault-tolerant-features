package br.com.emmanuelneri.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InactiveFeatureException extends RuntimeException {

    public InactiveFeatureException(final String message) {
        super(message);
    }
}
