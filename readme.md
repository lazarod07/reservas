Pasos para ejecutar aplicación carrito de compras en Spring Boot

1. Instalar Java 17 y agragarlo al PATH .
2. Intalar Git .
3. Instalar Spring Tools 4 o Eclipse IDE .
4. Usando el comando "git clone", clonar repositorio .
	git clone https://github.com/lazarod07/reservas
5. Abrir con Spring Tools 4 o Eclipse IDE el proyecto clonado .
6. Click derecho sobre el preyecto, ir a "Run as" y click sobre "maven clean" .
7. Click derecho sobre el preyecto, ir a "Run as" y click sobre "maven install" .
8. Click derecho sobre el preyecto, ir a "Run as" y click sobre "Spring Boot App" .

Luego de estos pasos, el proyecto debe estar ejecutandose en su computador.

Una vez el proyecto este ejecutandose en su computador, ir a http://localhost:8081/swagger-ui

Allí se encontrará todas los servicios solicitados y una manera facil de probarlos



Indicaciones adicionales.
Configuraciones necesarias.
1.Base de datos.
url: jdbc:mysql://localhost:3306
server: :localhost
puerto: 3306
usuario: root
contraseña: root
Una vez la base de datos esté establecida, ejecutar en orden cada una de las consultas sql que se encuentran en el archivo “esquemaTablasDatos.txt” (Archivo ubicado dentro del proyecto Spring Boot).
Luego de haber realizado lo anterior, se podrá ejecutar la aplicación sin problemas.

2.Formato de fecha.
El formato de fecha utilizado es yyyy-mm-dd.

3.Para la creación de una reserva es necesario con anterioridad haber creado un Cliente, fue creado un servicio para la creación de Clientes.
