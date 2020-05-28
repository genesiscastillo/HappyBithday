# HappyBirthDay

Este proyecto se basada en calculo de dias faltante para su proximo cumpleaños, 
ademas si hoy esta de cumpleaños le entregara un conjunto de poemas del dia.

## Getting Started

### Consideraciones

* El backend debe estar en JAVA
* El Front end puede ser desarrollado en cualquier lenguaje
* Se valorará el uso de Pruebas unitarias
* El tiempo de entrega debe ser máximo 3 días después de recibir este correo

### Clone

To get started you can simply clone this repository using git:

``` 
https://github.com/genesiscastillo/HappyBithday.git
cd HappyBithday
```

### Configuration

To provide the following settings:

``` 
formato.patronFecha=dd-MM-yyyy
url.urlpoemist=https://www.poemist.com/api/v1/randompoems
```

The configuration is located in `src/main/resources/applsication.properties` .

### Build an executable JUNIT testing

You can run the application from the command line using:

``` 
mvn test
```

### Build an executable JAR

You can run the application from the command line using:

``` 
mvn spring-boot:run
```

Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:

``` 
mvn clean package
```

Then you can run the JAR file with:

``` 
java -jar target/*.jar
```

*Instead of `mvn` you can also use the maven-wrapper `./mvnw` to ensure you have everything necessary to run the Maven build.*

### Test your new HappyBirthDay app

1. open `http://localhost:8080/index.html` 

## For more information

For more information .

[1]: https://www.tutorialspoint.com/spring_boot/index.htm
[2]: https://www.baeldung.com/java-date-difference
[3]: https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm
[4]: https://www.baeldung.com/maven-wrapper

### Abstract Test Desarrollo

Construya un servicio REST que reciba como parámetro de entrada Nombre completo
(nombres y apellidos) y una fecha (DD-MM-YYYY) y retorne:
-Primer nombre y primer apellido
-Edad
-Cuántos días faltan para su cumpleaños o en caso de que sea su cumpleaños
felicitarlo y ocupar la siguiente API “ https://www.poemist.com/api/v1/randompoems ” para
dedicarle un poema random de la lista que responde
Este servicio debe ser consumido por un Frontend, que debe mostrar de forma persistente
los datos de cada una de las personas ingresadas en el siguiente formato:
-Nombre
-Apellido
-Fecha (DD/MM/YY)
-Edad
-Cuantos días para cumplir o Felicitación y poema según sea el caso
El código debe ser disponibilizado en un repositorio git cuyo README tenga las
instrucciones para deployar el proyecto
