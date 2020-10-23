.PHONY: setup dependencies build run

setup: \
	dependencies

dependencies:
	@type sbt > /dev/null

build:
	sbt compile

run:
	sbt run

