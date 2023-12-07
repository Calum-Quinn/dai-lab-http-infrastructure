# Commands used to start up the static server

## Build
`docker build --no-cache -t static-web-server .`

## Run
`docker run --name static-web-server -p 8080:80 -d static-web-server`

## Stop and remove to rerun with changes
`docker stop static-web-server`

`docker rm static-web-server`

`docker rmi static-web-server`