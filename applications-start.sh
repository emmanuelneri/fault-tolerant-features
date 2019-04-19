#!/usr/bin/env bash

docker run -itd \
    --name api \
    --link config-server \
    --link rabbit \
    -p 8080:8080 \
    fault-tolerant-features/api

docker run -itd \
    --name web \
    --link config-server \
    --link rabbit \
    -p 8090:8090 \
    fault-tolerant-features/web