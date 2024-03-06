# Sistema-Comercio-Electronico

Una tienda departamental solicita el desarrollo de una aplicación web que sea una tienda en linea, en la cual, pueda realizar ventas de los productos registrados en su inventario, actualizar el mismo conforme a las ventas, realizar pagos en linea, control de promociones y registro de usuarios.

El equipo de arquitectura del proyecto, ha decidido implementarlo tomando en cuenta las siguientes consideraciones:

1.- Implementar una arquitectura de microservicios.
2.- Los pagos en linea, se efectuaran mediante paypal.
3.- La conexión entre el back-end (microservicios / middleware) y el front-end, ser realizará mediante un message broker(RabbitMQ, Kafka, JMS, etc).
4.- Se utilizarán bases de dato relacionales )postgresql para los usuarios y mysql para los productos y servicios).
5.- Como mínimo, el message broker y las bases de datos deben ser ejecutadas y configuradas usando contenedores (docker).
6.- Se debe considerar la sanitización de campos tanto en el back-end como en el front-end para evitar la inyección de scripts maliciosos.
7.- Se debe implementar almenos una opción de login externa (facebook login, google, etc).
8.- Para efectos de pruebas y entrega, la aplicación debe tener un certificado autofirmado (SSL o TLS).
9.- Implementar pruebas unitarias tanto en front-end como en back-end.
10.- Implementar almenos 5 patrones de diseño.
11.- Usar prácticas de clean code y clean architecture.
Nice To Have: orquestas todos los componentes del sistema utilizando docker-compose.
