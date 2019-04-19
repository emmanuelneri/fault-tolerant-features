#!/usr/bin/env bash

mvn clean install
mvn -f config-server/pom.xml dockerfile:build
mvn -f api/pom.xml dockerfile:build
mvn -f web/pom.xml dockerfile:build