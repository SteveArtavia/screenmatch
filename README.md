# Screenmatch - API RESTful con Java Spring Boot

**Screenmatch** es una API RESTful desarrollada con Java y Spring Boot como parte del curso de Alura Latam.  
Permite consultar, guardar y administrar información sobre películas y series consumiendo datos desde la API de [OMDb](https://www.omdbapi.com/).

La API se conecta a un **frontend** para mostrar los datos al usuario final, permitiendo así una arquitectura basada en separación de responsabilidades (backend y frontend desacoplados).

---

## Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Web (API REST)
- Spring Data JPA + Hibernate
- Base de datos relacional (PostgreSQL)
- OMDb API
- Maven
- CORS
- Frontend conectado

---

## Funcionalidades principales

- Exponer una API RESTful con endpoints para consultar y guardar información de películas y series.
- Conexión a la API pública de OMDb para obtener los datos.
- Almacenamiento de datos en base de datos relacional.
- Endpoint para recibir peticiones del frontend.
- Soporte para configuración CORS para permitir comunicación con el cliente.
- Modelo basado en arquitectura MVC.

---

## Endpoints principales

| Método | Endpoint                  | Descripción                        |
|--------|---------------------------|------------------------------------|
| GET    | `/series`                 | Lista todas las series guardadas |
| GET    | `/series/{id}`            | Devuelve los detalles de una serie|
| GET    | `/series/lanzamientos`                 | Obtener lanzamientos mas recientes |
| POST   | `/series/top5`                 | Obtiene el top 5 de mejores series |

> Todos los endpoints están disponibles en formato JSON y son consumidos por el frontend.
