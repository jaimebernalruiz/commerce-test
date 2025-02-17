FROM amazoncorretto:17-alpine

# creacion directorio de trabajo 
WORKDIR /app

# copia de el jar del aplicativo 
COPY /target/orders-microservice-0.0.1.jar /app/orders-microservice.jar
 
# exposicion puerto 
EXPOSE 8080

# creacion directorio de trabajo 
ENTRYPOINT ["java", "-jar", "orders-microservice.jar"]