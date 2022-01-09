# Desafío técnico
## Introducción
El proyecto de desarrolló como parte de una prueba técnica.

## Startup del servidor
### Local
1.  **Clonar el proyecto:** 
	-	git clone https://github.com/elagro/bsv.git
2.  **Build** 
	-	cd bsv
	-	mvn clean install
3.  **Iniciar**	
    -   java -jar target\bsv-2.3.1.RELEASE.jar

### Cloud
(Este punto se encuenta en desarrollo) El proyecto se deployo en GCP siendo el endpoint: https://bsv-proy-rest.uc.r.appspot.com/persona.

## Servicios
A continuación se describen los servicios expuestos en el proyecto.
### GET: /persona
    Recibe la informción de las personas cargadas en la base de datos
    Como respuesta satisfactoria se responde HTTP Status 200.
    Body:
    [ {
        "id": 1,
        "nombre": "Lucas",
        "apellido": "Agro",
        "tipoDocumento": "DU",
        "nroDocumento": "30333333",
        "nacionalidad": "AR",
        "sexo": "M",
        "edad": 38,
        "fechaNacimiento": "1983-10-28",
        "email": "lucas@agro.com.ar",
        "nroTel": "3333333333"
    }]
    
    En caso de error se responde HTTP Status 500.

### GET: /persona/{id}
    Recibe la informción de una personas según el ID
    Como respuesta satisfactoria se responde HTTP Status 200.
    Body:
    {
        "id": 1,
        "nombre": "Lucas",
        "apellido": "Agro",
        "tipoDocumento": "DU",
        "nroDocumento": "30333333",
        "nacionalidad": "AR",
        "sexo": "M",
        "edad": 38,
        "fechaNacimiento": "1983-10-28",
        "email": "lucas@agro.com.ar",
        "nroTel": "3333333333"
    }
    
    En caso de error se responde HTTP Status 500.
    
### POST: /persona
    Envía una persona para ser persistida en la base.
    Body:
    {
        "nombre": "Juan 111dddssd   Carlos",
        "apellido": "Zarlanga",
        "tipoDocumento": "DU",
        "nroDocumento": "12444999",
        "nacionalidad": "CH",
        "sexo": "M",
        "fechaNacimiento": "1978-03-03",
        "email": "pipiripi@zaraza.com",
        "nroTel": "+54 11 3332288"
    }
   
    Como respuesta satisfactoria se responde HTTP Status 200 y en el Body el ID de la creación de la base de datos.
    
    En caso de error se responde HTTP Status 500.
    
### PUT: /persona
    Actualiza una persona en la base de datos según el ID informado en el body
    {
        "id": 2,
        "nombre": "2Juan ddddd   Carlos",
        "apellido": "Zarla2nga",
        "tipoDocumento": "DU",
        "nroDocumento": "220444999",
        "nacionalidad": "BR",
        "sexo": "M",
        "fechaNacimiento": "1978-03-03",
        "email": "pipiripi@zaraza.com",
        "nroTel": "+54 11 3332288"
    }
    Como respuesta satisfactoria se responde HTTP Status 200 y en el Body la persona.
    
    En caso de error se responde HTTP Status 500.

### DELETE: /persona/{id}
    Elimina una persona de la base de datos según el ID informado
    
    Como respuesta satisfactoria se responde HTTP Status 200.

    En caso de error se responde HTTP Status 500.

## Pruebas
### Postman
Para realziar las pruebas se generaró una batería de pruebas utilizando postman.
La colección se puede importar desde: https://www.getpostman.com/collections/26ee5967b7952ce623ec

##  Solución
La solución se implementó en Java 11, Spring Boot y base de datos en memoria H2

La solución del problema se separó en capas
-   Controlador: se presentan los servicios rest.
-   Servicios: se implementa la lógica de obtención de datos
-   Entidad: Se modeló:
    -   La entidad Persona la cual es persistida en la BD.
    -   La entidad Estadística la cual se utiliza para la respuesta del controlador.
-   DTO: se implementó la clase para separa la entidad de la base de datos de la información a enviar por el controlador

