Proyecto de Aplicación Web con MySQL


Este proyecto es una aplicación web basada en Java que utiliza el framework Spring boot y una base de datos MySQL para almacenar y recuperar datos. Proporciona formularios de inicio de sesión, registro de usuarios y modificaciónes de las reservas de los clientes. También, se pueden visualizar y filtrar los usuarios registrados (asesores y administradores). Los administradores son los únicos usuarios con el permiso de crear mas usuarios, mientras que los asesores solo pueden modificar las peticiones que realizan los clientes (las peticiones vienen quemadas en la base de datos, ya que la parte del cliente no es parte del software correspondiente).

Requisitos previos
- La versión Java o el paquete que se usa para ejecutar todo
- MySQL instalado y configurado en el dispositivo.
 
Configuración de la base de datos
1. Crea una base de datos en MySQL para la aplicación.
2. Tener en cuenta la configuración para HOST, USER, NAME, PORT y PASSWORD ó con la información de conexión de tu base de datos MySQL.

Ejecutar la aplicación
1. Abre una terminal y navega hasta la carpeta raíz del proyecto.
2. La aplicación web estará disponible en `http://localhost:8080` en tu dispositivo.

Uso de la aplicación
- Abre un navegador web e ingresa la URL `http://localhost:8080/index` y poder visualizar la aplicación.
- Se mostrará un formulario de inicio de sesión. Puedes utilizar las credenciales predeterminadas (Las quemadas, y si se quiere añadir un usuario nuevo, solo podrá hacerlo un administrador: username: hector_ramirez, contraseña: 123456).
- Después de iniciar sesión correctamente, se redirigirá a la página principal, donde puedes realizar diferentes acciones o ver información específica de los vuelos.

Eso es todo. Ahora puedes usar la aplicación web y conectarte a la base de datos MySQL en otro dispositivo. Si deseas realizar modificaciones en la aplicación, puedes explorar y editar los archivos en la carpeta del proyecto.

¡Disfruta usando la aplicación! Si tienes alguna pregunta, no dudes en contactar al desarrollador.
