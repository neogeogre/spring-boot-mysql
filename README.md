# spring-boot-mysql

minimalist spring boot app with mySQL

Demo to show a spring boot application with mySQL written in kotlin

### Java setup

Install `sdkman`

To autoload the `.sdkmanrc`:

in `$HOME/.sdkman/etc/config` set `sdkman_auto_env=true`

### How to run

Start the Elasticsearch `docker-compose` with:

```bash
docker-compose up -d
``` 

```shell
./gradlew clean build 
```

```shell
./gradlew clean build -xtest 
```

```bash
docker-compose down
``` 
