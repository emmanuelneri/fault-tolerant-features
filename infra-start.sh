#!/usr/bin/env bash

docker run -itd \
    --name rabbit \
    -p 5672:5672 \
    -p 15672:15672 \
    rabbitmq:management

 docker run -itd \
    --name config-server \
    --link rabbit \
    -p 8888:8888 \
    fault-tolerant-features/config-server