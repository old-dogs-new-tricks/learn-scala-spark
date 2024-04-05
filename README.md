# Essentialy Learning Scala and Spark

Homework sharing repo to goad, request help, and share insights of working through:

* [Essential Scala](https://www.goodreads.com/book/show/29354072-essential-scala), by Noel Welsh and Dave Gurnell
* [Learning Spark: Lightning-Fast Big Data Analysis](https://www.goodreads.com/book/show/24808098-learning-spark?from_search=true&from_srp=true&qid=fGjEwKhOoo&rank=1), Holden Karau, et al

## Environment

This branch has MZD's setup of a docker compose environment (initially) consisting of three containers using the Apache/Spark:latest image.

Three services are defined: a Spark Server("Master" - ew Colonizer!), a Worker, and a Scala [REPL](https://en.wikipedia.org/wiki/Read%E2%80%93eval%E2%80%93print_loop).
The essential differences are the entrypoint commands of each container and to give us handy names.

The spark-shell service gives us a Scala REPL.

MZD is using a silly tool to generate the docker-compose.yml from the snippits in the docker/ folder. It is optionally included in the `Makefile` but is not required to setup or use the environment.

* The Spark Server WebUI is available on [http://localhost:8080](http://localhost:8080).
* The Spark Context WebUI is available on [http://localhost:4040](http://localhost:4040)

## Work directory / Volume Mount

The spark container defaults to `/opt/spark/work-dir`, so the `work/` directory of this repo is bind-mounted there.
The intention is to not commit homework, just infrastructure to this branch. It's suggested to either fork this repo, and/or create your own homework branch in this repo.

## Makefile Wrapper

The Makefile (at this time) has two targets. 
* The `bash` target gives you a command prompt in the container for poking around.
* The `scala` target (alias also `repl`) runs the spark-shell launch script to start the Scala REPL.

For convenience, the Makefile will detect if the `spark-shell` service is running and use `run --rm` if not. If available, it will use `docker compose exec...`.




