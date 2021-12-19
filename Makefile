.PONY: all build test

all: build

build:
	@./gradlew assemble --warning-mode all

test:
	@./gradlew check --warning-mode all

.PHONY: run
run:
	@./gradlew :run
