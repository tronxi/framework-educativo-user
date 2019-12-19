FROM maven as builder
ARG clave
ENV clave_env ${clave}
COPY . .
RUN mvn package spring-boot:repackage -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env}

FROM openjdk:8-alpine
ARG clave
ENV clave_env ${clave}
ENV host_env defaultHost
COPY --from="builder" /target/framework-educativo-0.0.1-SNAPSHOT.jar .
CMD java -jar -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env} framework-educativo-0.0.1-SNAPSHOT.jar --spring.cloud.client.hostname=${host_env}