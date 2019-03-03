package br.com.emmanuelneri.app;

import lombok.Value;

@Value
public class Client {

    private Long id;
    private String name;
    private Classification classification;

    enum Classification {
        NEW,
        FREQUENT_BUYER,
        NEVER_BUYER
    }
}
