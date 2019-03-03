#!/usr/bin/env bash

url=http://localhost:8888

httpCode=$(curl -o /dev/null -s -w "%{http_code}\n" -X POST ${url}/actuator/bus-refresh \
   -H "Content-Type: application/json" \
   -d "")

if [ $httpCode -eq 200 ]; then
    echo "${url} refreshed!"
    break
  else
    echo "Refresh error!"
    echo "URL: ${url}!"
    echo "HTTP Code: ${httpCode}"
fi