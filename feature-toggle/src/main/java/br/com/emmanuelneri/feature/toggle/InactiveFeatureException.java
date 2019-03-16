package br.com.emmanuelneri.feature.toggle;

public class InactiveFeatureException extends RuntimeException {

    public InactiveFeatureException(final String message) {
        super(message);
    }
}
