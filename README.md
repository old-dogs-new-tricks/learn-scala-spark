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

## REPL Tips

As noted in the book, when you get to ch3.3, you'll want to use the `:paste` command in the REPL to enter multi-line code blocks. This is repl-speak for "include" that takes input from the clipboard or a file.

I therefor started putting exercises into files named for the exercise number. The `:paste` command is then used to include the file in a `.repl` file.

To run the exercises, you can use the `:load` command in the REPL to include the `.repl` file.

``` scala
// Exercise - Cats
:paste ch3.4.5.1.scala

val ozy = new Cat(name = "Oswald", food = "Milk")
val heny = new Cat(name = "Henderson", food = "Chips", colour = "Ginger")
val tin = new Cat(name = "Quentin", food = "Curry", colour = "Tabby and white")

// Exercise - Films
:paste ch3.4.5.2.scala

:load ch3.data.films.scala

println("> Director.older(eastwood, nolan).name")
Director.older(eastwood, nolan).name

println("> Film.highestRating(darkKnight, outlawJoseyWales)")
Film.highestRating(darkKnight, outlawJoseyWales)

println("> Film.oldestDirectorAtTheTime(dieHard, darkKnight).name")
Film.oldestDirectorAtTheTime(dieHard, darkKnight).name
```

``` scala
scala> :load ch3.4.repl
```

## Worksheets

To get started quickly and to follow the examples in the book precisely, I recommend just using the REPL. As the exercises get more complex, I think we will want slicker output. Worksheets seem to be a scala tool that aspire to be, but fall short of Jupyter notebooks style functionality. I tried VS Code, and saw screenshots of IntelliJ, but I'm not sure if they are worth the effort.

A few options appear to exist for Scala in Jupyter notebooks: [Almond](https://almond.sh/) and [Jupyter Scala](https://jupyter-scala.org/) and [Apache Zeppelin](https://zeppelin.apache.org/docs/0.10.1/quickstart/spark_with_zeppelin.html). I have not tried any of these yet.
