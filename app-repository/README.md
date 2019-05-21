# app-repository 

_Este proyecto almacenará todas las configuraciones necesarias para la conexión a la base de datos
ademas de tener configurado un pool de conexiones y todas las entidades del proyecto.

## Comenzando 🚀

_Este proyecto es un modulo del proyecto padre app-master-integration y es una librería empaquetada como jar del proyecto que se necesite.

### Pre-requisitos 📋

_Se debe tener configurado previamente un Apache tomcat en el cual estará corriendo la aplicación que se empaquetara en un war y son todos los proyectos que terminen en rest 
 
### Instalación 🔧

_Configuración tomcat

* Buscamos el archivo context.xml en <TOMCAT_HOME>/conf/ y agregamos dentro de la etiqueta principal del xml las siguientes configuraciones:

```
<Resource
    	  name="jdbc/microservicios"
    	  auth="Container"
    	  type="javax.sql.DataSource"
    	  factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
    	  initialSize="34"
    	  maxActive="377"
    	  maxIdle="233"
    	  minIdle="89"
    	  timeBetweenEvictionRunsMillis="34000"
    	  minEvictableIdleTimeMillis="55000"
    	  validationQuery="SELECT 1"
    	  validationInterval="34000"
    	  testOnBorrow="true"
    	  removeAbandoned="true"
    	  removeAbandonedTimeout="55"
    	  username="<user>"
    	  password="<password>"
    	  driverClassName="com.mysql.cj.jdbc.Driver"
    	  url="jdbc:mysql://<host_database>:<port-database>/<database>?useSSL=false&amp;serverTimezone=UTC"
     />
```
### Nota: Se debe reemplazar por los datos correctos lo que se encuentra entre <>
### Nota: Los números de conexiones que estan en la anterior configuración son para producción.


* Luego de esto añadiremos en nuestro properties del modulo de repositorio (app-repository) la siguiente linea con la ubicación del jndi con el nombre que corresponda

```
jdbc.url=java:comp/env/jdbc/microservicios
```
###nota: El nombre "jdbc/microservicios" depende de la configuracion que realizamos en nuestro servidor de aplicaciones

_Añadir librería al Tomcat

* Se debe copiar la libreria de mysql en la siguiente ruta del servidor donde se vaya a desplegar el proyecto <TOMCAT_HOME>/lib/



