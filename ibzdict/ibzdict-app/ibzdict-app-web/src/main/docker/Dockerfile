
FROM adoptopenjdk/openjdk8:jdk8u242-b08-centos

ENV TZ=Asia/Shanghai \
    SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBIZ_SLEEP}s..." && \
    sleep ${IBIZ_SLEEP} && \
    java ${JAVA_OPTS} -Duser.timezone=$TZ -Djava.security.egd=file:/dev/./urandom -jar /ibzdict-app-web.jar

EXPOSE 8080

ADD ibzdict-app-web.jar /ibzdict-app-web.jar
