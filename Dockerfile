FROM debian:stretch

ARG clave
ENV clave_env ${clave}

ENV host_env defaultHost

RUN apt update -y && \
    apt-get update -y && \
    apt install git -y && \
    apt install maven -y && \
    apt-get install openjdk-8-jdk -y

COPY . .

RUN git checkout develop && \
    mvn package spring-boot:repackage -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env}

WORKDIR /target

CMD java -jar -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env} framework-educativo-0.0.1-SNAPSHOT.jar --spring.cloud.client.hostname=${host_env}