package br.com.emmanuelneri.feature.toggle;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum Features implements Feature {

    @Label("Hello")
    HELLO,

    @Label("Clients")
    CLIENTS;

    public String getName() {
        return this.name();
    }

}
