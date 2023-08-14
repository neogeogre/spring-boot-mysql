## Hive suite

Install `sdkman` with `curl -s "https://get.sdkman.io" | bash`, then to autoload the `.sdkmanrc`, set `sdkman_auto_env=true` in `$HOME/.sdkman/etc/config`

Build all modules without tests:

```shell
./gradlew clean build -xtest
```

Build all modules with tests:

```shell
./gradlew clean build
```

Start a single spring app:

```shell
./gradlew clean app:bootRun
```

### Some useful gradle plugins tasks

- See dependency tree: `./gradlew dependencyReport`
- See dependency tree as interactive webpage: `./gradlew build -xtest --scan`
- Get modules versions: `./gradlew printSemver`
- Create a new version: `./gradlew createSemverTag -Psemver.stage=final -Psemver.scope=minor`
- Build snapshot docker images `./gradlew jibDockerBuild -Psemver.stage=snapshot -Psemver.tagPrefix=`
- Publish snapshot jars in nexus:
    ```shell
    ./gradlew publish -Psemver.stage=snapshot -Psemver.tagPrefix=
    ```

Stop all hidden gradle daemons:

```shell
./gradlew --stop
```

### GitOps

Push all git tags:

```shell
git push --tags
```

delete a git tag:

```shell
TAG="0.2.0"
git tag -d $TAG
git push --delete origin $TAG
```

### Liquibase

Generate changelog squash:

```shell
/home/geoffrey/Downloads/liquibase-4.23.0/liquibase generate-changelog \
  --classpath=$HOME/Downloads/h2-2.2.220.jar \
  --driver=org.h2.Driver \
  --url=jdbc:h2:file:/home/geoffrey/Desktop/git/hive-shopfloor-backend/data/hive \
  --username=sa \
  --password=password \
  --schemas=PUBLIC \
  --changeLogFile=changelog-h2.xml
```

### Docker compose 

To fix the old docker compose cli running in the gradle plugin do: https://stackoverflow.com/a/72187587

Stop all docker containers if they remained live by mistake:

```shell 
docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q)
```
