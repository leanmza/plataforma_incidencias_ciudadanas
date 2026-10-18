# inciApp – Backend

Backend del proyecto final de **Programación II** y **Modelado de Software**.

# Equipo
Leandro Hidalgo, Gonzalo Centeno, Walter Marín, Franco Barrera

**Versión 1.0.0**

Plataforma para reportar incidentes ciudadanos, como ramas caídas, acequias tapadas o problemas en la recolección de residuos. Cada incidente pasa por distintos estados,
lo que permite hacer su seguimiento desde que se reporta hasta que se resuelve.

## Funcionalidades

- Registro e inicio de sesión de usuarios con JWT
- Roles y permisos (ADMIN / USER)
- Alta, edición y consulta de incidentes
- Seguimiento por estados y asignación de prioridad
- Ubicación por provincia, departamento y localidad

## Tecnologías

- Java 21
- Spring Boot 4 (Web, Data JPA, Security, Validation)
- MySQL
- JWT (java-jwt de Auth0)
- MapStruct y Lombok
- Maven

