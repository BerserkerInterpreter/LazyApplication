# LazyLoading
Repositorio creado para almacenar el mini-proyecto de seleccion.

Buen dia,

Se ha creado este repositorio con el proposito de contener los archivos relacionados con la implementacion de la solucion para el ejercicio llamado "Carga Perezoza" (Lazy Loading).

Los archivos contenidos en este repositorio van desde la implementacion de las clases del microservicio hasta los archivos web que contienen el frontend de la aplicacion o interfaz al usuario. La aplicacion fue implementada utilizando varias herramientas o componentes principales los cuales son descritos:

  1. Spring Boot 1.5.2
  2. Angular JS 1.6
  3. Java 1.8.0_111
  4. Javascript
  5. HTML 5
  6. Eclipse Neon 3

Se coloca un enlace o url que apunta hacia la ubicacion de los workspaces (archivos de trabajo) que contienen tanto el workspace del microservicio como tambien el workspace de la aplicacion web desarrollada en AngularJS (los componentes estan bajo la carpeta denominada "componentes" comprimidos en un archivo de tipo rar):

  * https://drive.google.com/open?id=0Bzcv9iF_tEtAa1hYOWNsMEN4RXM
  
Para ejecutar los componentes solo es necesario abrir los workspaces en el IDE Eclipse (preferiblemente la version Neon 3) una vez cuente con el plugin instalado y descargado llamado "Spring IDE 3.8.4 RELEASE", un servidor TOMCAT version 8.5 (instalado y configurado en el IDE Eclipse). Posteriormente se inicia el microservicio como un servicio de tipo Spring Boot y se ejecuta el archivo index.html del componente web en el servidor tomcat, o se introduce la siguiente direccion:

  * http://localhost:8282/LazyLoadingAngularProject/htmlfiles/index.html#!/formularioArchivo
  
Una vez se haya introducido las direcciones respectivas aparecera una pantalla muy simple la cual requiere un campo llamado "cedula" y un archivo que contiene los datos a procesar (la cantidad de dias y elementos que llevara el mensajero). Se introduce la cedula y el archivo dado y se ejecuta el boton llamado "Submit". Despues el microservicio procesara los datos incluidos dentro del archivo y retornara un resultado el cual aparecera en una tabla de otra pagina denominada "ejecucion archivo".

Cualquier inquietud que tengan no olviden comunicarse conmigo al correo "saldarriagadavid15@gmail.com".

Muchas gracias.
