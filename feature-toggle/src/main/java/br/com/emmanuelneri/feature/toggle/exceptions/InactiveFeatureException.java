package br.com.emmanuelneri.feature.toggle.exceptions;

public class InactiveFeatureException extends RuntimeException {

    public InactiveFeatureException(final String message) {
        super(message);
    }
}
