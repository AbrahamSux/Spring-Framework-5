# Spring-Framework-5
Curso de Spring Framework 5 y Spring Boot 2, se realiza paso a paso y desde cero el desarrollode una aplicación web con Spring, un completo sistema de facturación; Spring Security, autenticación basada en JWT (JSON Web Token), también una aplicación e-commerce con carro de compras, integración de Spring con Angular 9 y más.  También se verá en detalle todo lo relacionado al despliegue en producción (deploy), con diferentes alternativas, de forma local y en servicios en la nube con Heroku.

## Inicio
Para construir esta WebApp se requieren como versiones mínimas:
 
 * Java 8
 * Maven 3

## Información General
Para facilitar su despliegue se ha establecido un puerto predeterminado para la aplicación en el archivo de propiedades por default, el puerto del despligue es

````
8086
````

La dirección completa para desplegar la WebApp es la ruta siguiente:

http://localhost:8086/

## Despliegue
En caso de querer realizarlo de manera manual, se deben realizar los siguientes pasos:

0. Verificar las variables de entorno configuradas:

    ````
    JAVA_HOME = C:\Program Files\Java\jdk1.8.0_221
    M2_HOME = C:\apache-maven-3.6.3
    M2_REPO = C:\Users\Quarksoft\.m2\repository
   
    NOTA: comando a ejecutar para validar la versión de Maven y JAVA configuradas:
    mvn -version
    ````
   
1. Acceder a la ruta de la aplicación:

    ````
    cd C:\Professional_Courses\Workspace_Udemy\Spring-Framework-5
    ````

2. Empaquetamiento de la WebApp:
    
    ````
    .\mvnw.cmd package
    ````

3. Despliegue manual del jar:
    
    ````
    java -jar .\target\Spring-Framework-5-0.0.1-SNAPSHOT.jar
    ````

## Perfiles
La WebApp proporciona los siguientes perfiles que permiten orientar el código hacia diferentes ambientes, según
sea el ciclo de desarrollo:

*
*
*
