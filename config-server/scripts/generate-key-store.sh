#!/bin/bash

keytool -genkeypair \
    -alias configServer \
    -keystore config-server.jks \
    -storepass configServerPass \
    -keyalg RSA \
    -keypass configServerPass \
    -dname 'CN=www.emmanuelneri.com.br, OU=Fault-Tolerant Features, O=Emmanuel Neri, L=Sao Paulo, C=BR'