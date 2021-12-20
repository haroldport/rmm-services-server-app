.PHONY: all
all: build

.PHONY: up
up:
	@docker-compose up -d

.PHONY: build
build:
	@./gradlew build --warning-mode all

.PHONY: run-tests
run-tests:
	@./gradlew test --warning-mode all

.PHONY: test
test:
	@docker exec ninjaone-rmm_services_server_app-java ./gradlew test --warning-mode all

.PHONY: run
run:
	@./gradlew :run
