# Developing modern web application with Spring Boot with React.js

This is a skeleton application you'll be starting with in the workshop. You'll definitely need:

* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3.3.x](https://maven.apache.org/download.cgi). Even though most modern IDEs have Maven bundled we will need the latest version.
* [Node.js 4.4.x + npm 2.15.x](https://nodejs.org/en/download/)
* [Git client](https://git-scm.com/downloads)
* IDE, preferably [IntelliJ IDEA](https://www.jetbrains.com/idea/?fromMenu) (Ultimate edition - 30 day trial). You may use other IDE but
you need to know it well.
* Patience and pro-learning attitude :)

## Building and running the application

Simply put, to build everything just run:

`mvn clean package -Pbuild-frontend`

This will build both backend and frontend and create an executable jar. Then, application can be started via

`mvn spring-boot:run`

### Backend only

To build backend only run:

`mvn clean package`

### Frontend only

In frontend directory (`cd src/main/frontend`) execute:

`npm start`

to run the webpack-dev-server. This will start frontend app in development mode with hot-reloading capabilities. 
To build frontend as production-ready bundle run:

`npm run build`