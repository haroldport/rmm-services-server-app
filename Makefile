.PHONY: all
all: up build run

.PHONY: up
up:
	@docker-compose up -d

.PHONY: build
build:
	@./gradlew build --warning-mode all

.PHONY: test
test:
	@./gradlew test --warning-mode all

.PHONY: run
run:
	@./gradlew :run
