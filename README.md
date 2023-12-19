# DAI Labo HTTP Infrastructure

## Configuration

The specific configuration for our static web server is included in the [Dockerfile](Dockerfile) and [conf](config/nginx.conf) files.

### Dockerfile
The Dockerfile configures:
- Which image it uses `nginx`.
- What files to copy the image and from where.
- Which port to expose for external connection.

### nginx.conf
The nginx.conf file configures:
- The number of connections that each worker can handle.
- On which port to listen.
- The location of the files to use for the Website.
- The default file to use for the content.
- Custom error pages to create

### compose.yaml
The compose.yaml configures:
- The image to be built by docker compose.
- The local and external ports to use for accessing the image.