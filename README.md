# LazyApplication

Buen dia,

Los archivos contenidos en este repositorio van desde la implementacion de las clases del microservicio hasta los archivos web que contienen el frontend de la aplicacion o interfaz al usuario. La aplicacion fue implementada utilizando varias herramientas o componentes principales los cuales son descritos:

  1. Spring Boot 1.5.2
  2. Angular JS 1.6
  3. Java 1.8.0_111
  4. Javascript
  5. HTML 5
  6. Eclipse Neon 3
  
Se colocan los workspaces respectivos bajo la carpeta denominada "workspaces". Los workspaces funcionan bajo la plataforma eclipse. 

El archivo utilizado para probar la funcionalidad del aplicativo implementado se encuentra bajo la carpeta workspaces con el nombre: lazy_loading_example_input.txt. Este archivo debe ser suministrado en la pagina "formulario_archivo.html".

EJECUCION COMO UN ARCHIVO EJECUTABLE JAR

El microservicio LazyLoading puede ser ejecutado como archivo .jar de java. Para realizar este tipo de ejecucion es necesario descargar dos componentes: LazyLoading4.jar y LazyLoading4_lib.tar.gz (se debe descomprimir) y almacenarlos en una carpeta. Despues, se puede proceder a ejecutar el componente LazyLoading4.jar con la siguiente sentencia java: java -jar LazyLoading4.jar lo cual iniciara el framework Spring Boot con el microservicio desplegado "http://localhost:8080" (direccion por defecto).

El componente LazyLoading4_lib contiene todas las librerias necesarias para la ejecucion del microservicio implementado.

EJECUCION EN ECLIPSE
  
Para ejecutar los componentes solo es necesario abrir los workspaces en el IDE Eclipse (preferiblemente la version Neon 3) una vez cuente con el plugin instalado y descargado llamado "Spring IDE 3.8.4 RELEASE", un servidor TOMCAT version 8.5 (instalado y configurado en el IDE Eclipse). Posteriormente se inicia el microservicio como un servicio de tipo Spring Boot y se ejecuta el archivo index.html del componente web en el servidor tomcat, o se introduce la siguiente direccion:

  * http://localhost:8282/LazyLoadingAngularProject/htmlfiles/index.html#!/formularioArchivo
  
Una vez se haya introducido las direcciones respectivas aparecera una pantalla muy simple la cual requiere un campo llamado "cedula" y un archivo que contiene los datos a procesar (la cantidad de dias y elementos que llevara el mensajero). Se introduce la cedula y el archivo dado y se ejecuta el boton llamado "Submit". Despues el microservicio procesara los datos incluidos dentro del archivo y retornara un resultado el cual aparecera en una tabla de otra pagina denominada "ejecucion archivo".

Cualquier inquietud que tengan no olviden comunicarse conmigo al correo "jdsaldarriaga7@gmail.com".

Muchas gracias.
