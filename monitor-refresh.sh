#!/usr/bin/env bash

url=http://localhost:8888

httpCode=$(curl -o /dev/null -s -w "%{http_code}\n" -X POST ${url}/actuator/bus-refresh \
   -H "Content-Type: application/json" \
   -d "")

 echo "Config bus refreshed!"