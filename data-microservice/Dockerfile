FROM amazoncorretto:17-alpine

# creacion directorio de trabajo 
WORKDIR /app

# copia de el jar del aplicativo 
COPY /target/data-microservice-0.0.1.jar /app/data-microservice.jar
 
# exposicion puerto 
EXPOSE 8080

# creacion directorio de trabajo 
ENTRYPOINT ["java", "-jar", "data-microservice.jar"]