.PHONY: setup dependencies volumes build clean

NAME := tamakiii-sandbox/hello-scala

setup: \
	dependencies \
	volumes

dependencies:
	@type docker > /dev/null

volumes:
	docker volume create --driver=local $(subst /,-,$(NAME))-sbt
	docker volume create --driver=local $(subst /,-,$(NAME))-ivy2

build:
	docker build -t $(NAME) .

bash:
	docker run -it --rm \
		-v $(PWD):/work \
		-v $(subst /,-,$(NAME))-sbt:/root/.sbt \
		-v $(subst /,-,$(NAME))-ivy2:/root/.ivy2 \
		-w /work \
		$(NAME) \
		bash

docker/install-sdkman.sh:
	curl -s "https://get.sdkman.io" > $@
	chmod u+x $@

clean:
	docker image rm $(NAME)
	docker volume rm $(subst /,-,$(NAME))-sbt
	docker volume rm $(subst /,-,$(NAME))-ivy2
