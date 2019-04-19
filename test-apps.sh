#!/usr/bin/env bash

apiUrl=http://localhost:8080/api
webUrl=http://localhost:8090/web

echo "API - Hello: $(curl -s ${apiUrl}/hello)"
echo "Web - Hello: $(curl -s ${webUrl}/hello)"

echo "API - Clients: $(curl -s ${apiUrl}/clients)"
echo "Web - Clients: $(curl -s ${webUrl}/clients)"