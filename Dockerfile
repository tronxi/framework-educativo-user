FROM jimschubert/8-jdk-alpine-mvn

ARG clave
ENV clave_env ${clave}

ENV host_env defaultHost

COPY . .

RUN mvn package spring-boot:repackage -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env}

WORKDIR /target

CMD java -jar -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env} framework-educativo-0.0.1-SNAPSHOT.jar --spring.cloud.client.hostname=${host_env}