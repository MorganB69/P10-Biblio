FROM postgres:latest
COPY ./init/db/docker-entrypoint-initdb.d /docker-entrypoint-initdb.d