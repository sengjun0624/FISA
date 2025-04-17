FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar","app.jar"]

#docker tag local-image:tagname new-repo:tagname
#docker push new-repo:tagname
