FROM debian:stretch
ARG token
ARG clave
ENV clave_env ${clave}
RUN apt update -y
RUN apt-get update
RUN apt install git -y
RUN apt install maven -y
RUN apt-get install openjdk-8-jdk -y
ADD https://${token}:x-oauth-basic@api.github.com/repos/tronxi/framework-educativo-user/git/refs/heads/develop version.json
RUN git clone https://${token}:x-oauth-basic@github.com/tronxi/framework-educativo-user
RUN cd framework-educativo-user && \
    git checkout develop && \
    mvn package spring-boot:repackage -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env} && \
    cd target && \
    mv framework-educativo-0.0.1-SNAPSHOT.jar user-dev.jar
WORKDIR /framework-educativo-user/target
CMD java -jar -Dspring.profiles.active=dev -Djasypt.encryptor.password=${clave_env} user-dev.jar