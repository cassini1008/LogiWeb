# LogiWeb

Sistema de gestión logística y de envíos desarrollado en Java con Spring Boot.

## Descripción
LogiWeb gestiona envíos terrestres y aéreos, automatiza el cálculo del costo por tipo de transporte y ofrece una interfaz web con Thymeleaf para visualizar los datos del pedido.

## Tecnologías
- Java 17
- Spring Boot 3.3.4
- Spring Web
- Thymeleaf
- Maven

## Estructura principal
- `com.example.demo.model` — entidades del dominio
- `com.example.demo.service` — lógica de negocio
- `com.example.demo.controller` — controladores web
- `src/main/resources/templates` — vistas HTML

## Ejecución en Render
Para despliegue en Render, la aplicación usa el puerto definido por la variable `PORT`.

Ejemplo de configuración recomendada:

```properties
server.port=${PORT:8080}
```

## Comando de compilación
```bash
./mvnw clean package
```

## Ejecución
```bash
java -jar target/logiweb-0.0.1-SNAPSHOT.jar
```
