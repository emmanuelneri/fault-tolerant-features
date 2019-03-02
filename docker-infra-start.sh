#!/usr/bin/env bash

 docker run -itd \
    --name config-server \
    -p 8888:8888 \
    fault-tolerant-features/config-server