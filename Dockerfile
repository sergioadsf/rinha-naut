FROM gradle:jdk11 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM gcr.io/distroless/java11-debian11
EXPOSE 8080
COPY --from=gradleimage /home/gradle/source/build/libs/*.jar /app/
WORKDIR /app
CMD java -jar rinha-naut-0.1-all.jar
#CMD ["rinha-naut-0.1-all.jar"]

