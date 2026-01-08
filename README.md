# code-with-quarkus

Este proyecto utiliza Quarkus, el Framework Java supersónico y subatómico.

Si deseas aprender más sobre Quarkus, visita su sitio web: <https://quarkus.io/>.

## Ejecutar la aplicación en modo desarrollo

Puedes ejecutar tu aplicación en modo desarrollo, lo que habilita la codificación en vivo, usando:

```shell script
./mvnw quarkus:dev
```

> **_NOTA:_** Quarkus ahora incluye una Dev UI, disponible solo en modo desarrollo en <http://localhost:8080/q/dev/>.

## Agregar la dependencia de OpenAPI

Para habilitar la documentación OpenAPI y Swagger UI, agrega la extensión ejecutando:

```shell script
./mvnw quarkus:add-extension -Dextensions="smallrye-openapi"
```

## Empaquetar y ejecutar la aplicación

La aplicación puede empaquetarse usando:

```shell script
./mvnw package
```

Esto produce el archivo `quarkus-run.jar` en el directorio `target/quarkus-app/`.
Ten en cuenta que no es un _über-jar_, ya que las dependencias se copian en el directorio `target/quarkus-app/lib/`.

La aplicación ahora se puede ejecutar usando `java -jar target/quarkus-app/quarkus-run.jar`.

Si deseas construir un _über-jar_, ejecuta el siguiente comando:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

La aplicación, empaquetada como un _über-jar_, ahora se puede ejecutar usando `java -jar target/*-runner.jar`.

## Crear un ejecutable nativo

Puedes crear un ejecutable nativo usando:

```shell script
./mvnw package -Dnative
```

O, si no tienes GraalVM instalado, puedes ejecutar la construcción del ejecutable nativo en un contenedor usando:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Luego puedes ejecutar tu ejecutable nativo con: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

Si deseas aprender más sobre la construcción de ejecutables nativos, consulta <https://quarkus.io/guides/maven-tooling>.

## Guías relacionadas

- REST ([guía](https://quarkus.io/guides/rest)): Una implementación de Jakarta REST que utiliza procesamiento en tiempo de compilación y Vert.x. Esta extensión no es compatible con la extensión quarkus-resteasy, ni con ninguna de las extensiones que dependen de ella.
- REST Jackson ([guía](https://quarkus.io/guides/rest#json-serialisation)): Soporte de serialización Jackson para Quarkus REST. Esta extensión no es compatible con la extensión quarkus-resteasy, ni con ninguna de las extensiones que dependen de ella.

## Código proporcionado

### REST

Inicia fácilmente tus servicios web REST

[Sección de la guía relacionada...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)


## 🚀 Guía de Despliegue por Perfiles

Este proyecto está configurado para manejar diferentes comportamientos según el entorno mediante perfiles de Quarkus.

### 1. Perfil de Desarrollo (`dev`)
Ideal para el desarrollo diario gracias al **Live Coding**.
* **Comando:** `./mvnw quarkus:dev`
* **Puerto:** `8080`
* **Documentación (Swagger UI):** Disponible en [http://localhost:8080/docs](http://localhost:8080/docs)
* **Consola Dev UI:** [http://localhost:8080/q/dev/](http://localhost:8080/q/dev/)

### 2. Perfil de Producción (`prod`)
Optimizado para rendimiento y seguridad. Deshabilita herramientas de depuración.
* **Empaquetado:** `./mvnw package`
* **Ejecución:** `java -jar target/quarkus-app/quarkus-run.jar`
* **Puerto:** `9090`
* **Documentación (Swagger UI):** **Bloqueada (404 Not Found)** por motivos de seguridad.

---

## 🛡️ Reglas de Seguridad y Configuración

### Exposición de Swagger UI
Para evitar que se descubra la estructura de la API en entornos productivos, se utiliza la siguiente propiedad en `application.properties`:
```properties
%prod.quarkus.swagger-ui.always-include=false