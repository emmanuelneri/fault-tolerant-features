package br.com.emmanuelneri.app;

import br.com.emmanuelneri.feature.toggle.InactiveFeatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InactiveFeatureException.class)
    public ResponseEntity<String> handleError(InactiveFeatureException ifex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ifex.getMessage());
    }

}
