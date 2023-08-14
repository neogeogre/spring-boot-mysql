### Plugins dependency architecture

```
              kotlin (jvm 17)
                 |
              common (maven + project-report + semver)
                 |
            spring-boot
        _________|_________
       |                   |
openapi-generator    docker-compose
       |                   |
       |                  jib
       |                   |
 spring-boot-lib     spring-boot-app
```
