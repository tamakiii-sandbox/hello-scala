.PHONY: setup dependencies build run console

setup: \
	dependencies

dependencies:
	@type sbt > /dev/null

build:
	sbt compile

run:
	sbt run

console:
	sbt console
