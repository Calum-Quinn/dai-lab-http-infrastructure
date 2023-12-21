# DAI Labo HTTP Infrastructure

## Configuration

The specific configuration for our static web server is included in the
[Dockerfile](static_web_server/Dockerfile) and [conf](static_web_server/config/nginx.conf) files.
And the configuration for our API is int the [Dockerfile](api/Dockerfile) file and the [src](api/src) folder.

### Dockerfile (static web server)
The Dockerfile configures:
- Which image it uses `nginx`
- What files to copy the image and from where
- Which port to expose for external connection

### nginx.conf
The nginx.conf file configures:
- The number of connections that each worker can handle
- On which port to listen
- The location of the files to use for the Website
- The default file to use for the content
- Custom error pages to create

### Dockerfile (API)
The Dockerfile configures:
- An app builder
  - Which image it uses 'eclipse-temurin:21' for java 21
  - The working directory '/app'
  - What files to copy to the container (.mvn,mvnw,pom.xml,src)
  - The dependency downloads
- The app
  - Which image it uses 'eclipse-temurin:21' for java 21
  - The working directory '/app'
  - Where to copy the .jar file from
  - The command to use to execute the .jar file

### compose.yaml
The compose.yaml configures:
- The static web server image
  - The image to be built by docker compose
  - The local and external ports to use for accessing the image
- The API image
  - The image name
  - The image to be built
  - The local and external ports to use for accessing the image