
FROM ibiz4j/openjdk:8-jre-alpine3.9-fonts
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBIZ_SLEEP}s..." && \
    sleep ${IBIZ_SLEEP} && \
    java ${JAVA_OPTS} -Duser.timezone=$TZ -Djava.security.egd=file:/dev/./urandom -jar /ibizlab-runtime.jar

EXPOSE 10086

ADD ibizlab-runtime.jar /ibizlab-runtime.jar

#docker buildx build --platform linux/arm64,linux/amd64 -t ibiz4j/ibizlab-runtime:1.0.51 -t ibiz4j/ibizlab-runtime:latest --push .