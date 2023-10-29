FROM openjdk:11-jdk-slim
ARG JAR_FILE=stock/target/stock-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/.urandom","-jar","/app.jar"]