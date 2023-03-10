# Spring Boot Template for Kotlin

![CI Status](https://github.com/lomasz/spring-boot-kt-template/workflows/CI/badge.svg)
![CodeQL Status](https://github.com/lomasz/spring-boot-kt-template/workflows/CodeQL/badge.svg)

* Spring Boot + Web + JPA + REST
* Gradle Wrapper
* MapStruct
* Swagger
* H2 (embedded database)
* JUnit 5
* JaCoCo Java Code Coverage

## How to reuse template

- [ ] [`settings.gradle`](settings.gradle):
    * change **`rootProject.name`** value
- [ ] [`build.gradle`](build.gradle):
    * change **`group`** value
- [ ] [`OpenApiConfig.java`](src/main/java/com/lomasz/spring/boot/template/config/OpenApiConfig.java):
    * change description in **`swaggerApi()`** and **`CONTACT`**
- [ ] [`src/main`](src/main):
    * rename main package value
- [ ] [`application.properties`](src/main/resources/application.properties):
    * change **`server.port`** value
- [ ] [`Dockerfile`](Dockerfile):
    * modify all labels values
    * set `EXPOSE` value
- [ ] [`docker-compose.yml`](docker-compose.yml):
    * change image name
    * change port mapping
- [ ] [`docker-compose.yml`](docker-compose.yml):
    * change image name
    * change port mapping
- [ ] [`spring-boot-template.deployment.yml`](spring-boot-kt-template.deployment.yml)
- [ ] [`spring-boot-template.service.yml`](spring-boot-kt-template.service.yml)

## How to run application

#### using gradle wrapper

```bash
./gradlew clean bootRun
```

#### using docker-compose

```bash
docker-compose up --build -d
```

#### using k8s

```bash
docker build . -t spring-boot-kt-template:latest
kubectl apply -f spring-boot-kt-template.deployment.yml -f spring-boot-kt-template.service.yml
kubectl port-forward service/spring-boot-kt-template 4326:4326 
```

## Actuator

* [`http://localhost:4326/actuator/health`](http://localhost:4326/actuator/health) - health information (status)
* [`http://localhost:4326/actuator/info`](http://localhost:4326/actuator/info) - application basic information

## API Documentation

* [`http://localhost:4326/v3/api-docs`](http://localhost:4326/v3/api-docs) - API Docs [JSON]
* [`http://localhost:4326/v3/api-docs.yaml`](http://localhost:4326/v3/api-docs.yaml) - API Docs [YAML]
* [`http://localhost:4326/swagger-ui.html`](http://localhost:4326/swagger-ui.html) - Swagger UI
