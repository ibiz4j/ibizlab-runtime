
FROM ibiz4j/openjdk:8-jre-alpine-font
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBIZ_SLEEP}s..." && \
    sleep ${IBIZ_SLEEP} && \
    java ${JAVA_OPTS} -Duser.timezone=$TZ -Djava.security.egd=file:/dev/./urandom -jar /ibizlab-runtime.jar

EXPOSE 10086

ADD ibizlab-runtime.jar /ibizlab-runtime.jar
