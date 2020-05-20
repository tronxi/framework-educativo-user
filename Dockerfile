FROM alpine/git as git
WORKDIR /repo
ADD https://api.github.com/repos/tronxi/framework-educativo-user/git/refs/heads/develop version.json
RUN git clone https://github.com/tronxi/framework-educativo-user.git
RUN cd framework-educativo-user && git checkout develop

FROM maven as builder
COPY --from="git" /repo/framework-educativo-user .
RUN mvn package spring-boot:repackage

FROM openjdk:8-alpine
ENV clave clave
ENV eureka_host http://localhost
ENV user_service user-service
ENV profile dev
ENV rabbit_host localhost
ENV rabbit_pass guest
ENV user_bd localhost
COPY --from="builder" /target/framework-educativo-0.0.1-SNAPSHOT.jar .
CMD java -jar -Dspring.profiles.active=${profile} -Djasypt.encryptor.password=${clave} framework-educativo-0.0.1-SNAPSHOT.jar --eureka-host=${eureka_host} --user-service=${user_service} --user-bd=${user_bd} --spring.rabbitmq.host=${rabbit_host} --spring.rabbitmq.password=${rabbit_pass}