FROM amazoncorretto:17-alpine

# creacion directorio de trabajo 
WORKDIR /app

# copia de el jar del aplicativo 
COPY /target/users-microservice-0.0.1.jar /app/users-microservice.jar
 
# exposicion puerto 
EXPOSE 8080

# creacion directorio de trabajo 
ENTRYPOINT ["java", "-jar", "users-microservice.jar"]