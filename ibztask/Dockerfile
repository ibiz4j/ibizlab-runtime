
FROM openjdk:8-jre-alpine3.9
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBIZ_SLEEP}s..." && \
    sleep ${IBIZ_SLEEP} && \
    java ${JAVA_OPTS} -Duser.timezone=$TZ -Djava.security.egd=file:/dev/./urandom -jar /ibztask.jar

EXPOSE 40005

ADD ibztask.jar /ibztask.jar

#docker buildx build --platform linux/arm64,linux/amd64 -t ibiz4j/ibizlab-task:1.0.47 -t ibiz4j/ibizlab-task:latest --push .