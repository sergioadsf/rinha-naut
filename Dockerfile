FROM gradle:7.2.0-jdk11
#FROM gcr.io/distroless/java11-debian11
#ENV DATASOURCES_DEFAULT_URL=jdbc:postgresql://db:5432/rinhadb
#ENV DATASOURCES_DEFAULT_USERNAME=postgres
#ENV DATASOURCES_DEFAULT_PASSWORD=1234
#
#ENV R2DBC_DATASOURCES_DEFAULT_URL=r2dbc:postgresql://db:5432/rinhadb
#ENV R2DBC_DATASOURCES_DEFAULT_USERNAME=postgres
#ENV R2DBC_DATASOURCES_DEFAULT_PASSWORD=1234

EXPOSE 8080
COPY /build/libs /app
WORKDIR /app
CMD java -jar rinha-naut-0.1-all.jar
#CMD ["rinha-naut-0.1-all.jar"]

