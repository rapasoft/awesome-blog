# Developing modern web application with Spring Boot with React.js

This is a skeleton application you'll be starting with in the workshop. You'll definitely need:

* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3.3.x](https://maven.apache.org/download.cgi). Even though most modern IDEs have Maven bundled we will need the latest version.
* [Node.js 4.4.x + npm 2.15.x](https://nodejs.org/en/download/)
* [Git client](https://git-scm.com/downloads)
* IDE, preferably [IntelliJ IDEA](https://www.jetbrains.com/idea/?fromMenu) (Ultimate edition - 30 day trial). You may use other IDE but
you need to know it well.
* Patience and pro-learning attitude :)

## Further advices
* Do have `mvn`, `java`, `npm`, `git` commands available on global `PATH`
* On Windows,
    * have project files within [short directory path](http://stackoverflow.com/questions/1880321/why-does-the-260-character-path-length-limit-exist-in-windows) (e.g. `C:\dev\work`)
    * use Git Bash for command line
* Ask questions if you don't understand something, wait for discussion if you have some comments or opinions

## Obtaining the code

Go to [Itera Gitlab](http://gitlab.intra.itera.no/pavol.rajzak/spring-boot-react-workshop) and copy repository url. Then clone it using Git Bash (or in IDE):

`git clone http://gitlab.intra.itera.no/pavol.rajzak/spring-boot-react-workshop.git`

## Building and running the application

Simply put, to build everything just run this command in the root directory (with pom.xml)

`mvn clean package -Pbuild-frontend`

This will build both backend and frontend and create an executable jar. Then, application can be started via

`mvn spring-boot:run`

### Backend only

To build backend only run:

`mvn clean package`

### Frontend only

In frontend directory (`cd <ROOT>/src/main/frontend`) execute:

`npm start`

to run the `webpack-dev-server`. This will start frontend app in development mode with hot-reloading capabilities.
To build frontend as production-ready bundle run:

`npm run build`

This command is however executed when maven builds the whole project (using `build-frontend` profile),
so you should use it only on rare occasions.

## Further information and links

* [CubeDrone's extremely accurate history of JavaScript (comic)](http://cube-drone.com/comics/c/relentless-persistence)
* [Richardson maturity model](http://martinfowler.com/articles/richardsonMaturityModel.html)
* [Spring Boot reference guide](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [React.js user guide](https://facebook.github.io/react/docs/getting-started.html)
* [New ES6 features](https://github.com/lukehoban/es6features)
* [JSX gotcha's](https://facebook.github.io/react/docs/jsx-gotchas.html)
* [Paypal's REST API design guide](https://github.com/paypal/api-standards/blob/master/api-style-guide.md)
* [♥ Facebook page of Itera Slovakia ♥](https://www.facebook.com/IteraSlovakia)

### Useful tools

* [Postman Chrome extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
* [React Developer Tools Chrome extension](https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi?hl=en)
