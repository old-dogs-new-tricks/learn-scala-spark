-include decomposer.mk # optional (discouraged for now) https://github.com/caracolazuldev/d-composer

export DEBUG=1

DKC ?= docker compose

task-up = $(if $(shell $(DKC) ps -q $(1)),$(1) is running)
exec-or-run = $(if $(call task-up,$1),exec,run --rm) $1

scala repl:
	$(DKC) $(call exec-or-run,spark-shell) /opt/spark/bin/spark-shell

bash:
	$(DKC) $(call exec-or-run,spark-shell) /bin/bash

scalac:
	$(DKC) $(call exec-or-run,scalac)
