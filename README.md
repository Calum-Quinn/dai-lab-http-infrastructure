# DAI Labo HTTP Infrastructure

## Static Web server

### Nginx configuration

The nginx configuration is located in the [config](static_web_server/config/nginx.conf) folder.
This file configures :

- The number of connections that each worker can handle
- On which port to listen
- The location of the files to use for the Website
- The default file to use for the content
- Custom error pages to create

### Dockerfile

The Dockerfile is located at the root of the [static_web_server](static_web_server) folder.
This file configures:

- Which image it uses `nginx`
- What files to copy from the directory to the container
- Which port to expose for external connection

## API

The API is a simple java application that uses the [Javalin](https://javalin.io/) framework and
[Maven](https://maven.apache.org/) to manage dependencies. This application manages a list of todos and supports all
CRUD operations. The API is located in the [src](api/src) folder.

### Classes

The API is composed of 3 classes :

The `Todo` class is a simple class that represents a todo. It has 2 attributes the name of the task and its status. Note
that there is an empty default constructor to allow the deserialization of the object.

The `TodoController` class is the class that manages the Todos. It has a list of default todos (instead of using a
database) and a method for each CRUD operation. Note that there is also a method `getRoot` that returns a simple text
which is used when we access the root of the API.

The `Api` class is the main class of the application. It creates a new instance of the `TodoController` class and
configures the Javalin server. It also defines the routes for each method of the `TodoController` class.

### Dockerfile

The Dockerfile is located at the root of the [api](api) folder.
This file configures:

- An app builder to automatically build the application
    - Which image it uses 'eclipse-temurin:21' for java 21
    - The working directory '/app'
    - What files to copy to the container (.mvn,mvnw,pom.xml,src)
    - The command to download the dependencies
    - The command to use to build the application
- The app
    - Which image it uses 'eclipse-temurin:21' for java 21
    - The working directory '/app'
    - The .jar file built by the app builder to copy to the container
    - The command to use to execute the .jar file
    - The port to expose for external connection

## Traefik reverse proxy

### Why it is useful

The Traefik reverse proxy is useful because it allows us to access the API and the static web server with a single
domain name (which is localhost) and a single port (80). This offers a centralized access point for the whole
infrastructure and allows us to easily add new services to the infrastructure. This makes the infrastructure more
manageable and more secure.

### How the dashboard works

The Traefik reverse proxy also has a dashboard that allows us to see the different services that are running and their
status. This dashboard is accessible at the address `http://localhost:8080`.

## Scalability and load balancing

### `compose.yaml` configuration

To allow docker compose to start multiple instances of the containers, we added the `deploy` with the `replicas` option
to the `compose.yaml` file. This option allows us to specify the number of instances of the container to start.

### How to dynamically update the number of instances

To dynamically update the number of instances of the containers, we must first start the infrastructure using :

```shell
docker compose up -d
```

Then we can use this command to update the number of instances of the containers. For example, to start 6 instances of
the static web server and 7 instances of the API :

```shell
docker compose up -d --scale static-web-server=6 --scale api=7
```

## compose.yaml - A COMPLETER

The compose.yaml configures:

- The static web server image
    - The image to be built by docker compose
    - The local and external ports to use for accessing the image
- The API image
    - The image name
    - The image to be built
    - The local and external ports to use for accessing the image