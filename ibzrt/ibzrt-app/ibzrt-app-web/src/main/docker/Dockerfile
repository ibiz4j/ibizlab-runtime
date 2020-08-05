
FROM openjdk:8-jre-alpine

ENV TZ=Asia/Shanghai \
    SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD echo "The application will start in ${IBIZ_SLEEP}s..." && \
    sleep ${IBIZ_SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /ibzrt-app-web.jar

EXPOSE 8080

ADD ibzrt-app-web.jar /ibzrt-app-web.jar
