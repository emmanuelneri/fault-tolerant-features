# distributed-configurations

---

Distributed configurations with Spring Cloud Config Server

## Preparing environment

#### Building applications

To build maven applications and generate docker images, run: 

```
./build.sh
```


## Start Environment 

#### Start infrastructure

To start Rabbit and Config Server
```
./infra-start.sh
```

After this, Config Server is available on ``http://localhost:8888/`` and Rabbit Management is available on ``http://localhost:15672``.

#### Start applications

To start API and WEB applications
```
./applications-start.sh
```

## To execute

Execute ``./test-apps.sh `` to test actives features:
```
API - Hello: Hello API
Web - Hello: Web API
API - Clients: Feature: Clients inactive.
Web - Clients: Feature: Clients inactive.
```

To update features configuration you need to configure the [Github Webhooks](https://developer.github.com/webhooks/creating/) or force the Config Server to update the configurations files with ``./monitor-refresh.sh``.  

