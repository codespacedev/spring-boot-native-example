# SpringBootRestExampleApp

Example of how to run *Spring Boot Native* **without parent**
[![](https://img.shields.io/static/v1?label=Sponsor&message=%E2%9D%A4&logo=GitHub&color=%23fe8e86)](https://github.com/sponsors/YunaBraska)

[![Build][build_shield]][build_link]
[![Maintainable][maintainable_shield]][maintainable_link]
[![Coverage][coverage_shield]][coverage_link]
[![Issues][issues_shield]][issues_link]
[![Commit][commit_shield]][commit_link]
[![Dependencies][dependency_shield]][dependency_link]
[![License][license_shield]][license_link]
[![Size][size_shield]][size_shield]
![Label][label_shield]
![Label][java_version]
![Label][spring_boot]

## Index

1. [Rest Endpoints](#rest-endpoints)
2. [Executable Jar](#executable-jar)
3. [Native](#native)
4. [Docker with Native](#docker-with-native)

## Rest Endpoints

* Print all envs (without secrets)

> GET http://localhost:8080/envs

## Executable Jar

### Requirements

* JDK 17
* Result: ~ 18mb

> Build [`./mvnw clean package`]

> Run [`java -jar target/app.jar`]

> Build & Run [`./mvnw clean package && java -jar target/app.jar`]

## Native

### Requirements

* JDK 17
* [Graalvm](https://www.graalvm.org/22.0/docs/getting-started/#install-graalvm) ([brew](https://github.com/graalvm/homebrew-tap))
* Create native image (`gu install native-image`)
* Result: ~ 60mb

> Build [`./mvnw clean package -Pnative`]

> Run [`java -jar target/app.native`]

> Build & Run [`./mvnw clean package -Pnative && target/app.native`]

## Docker with Native

### Requirements

* Docker (4GB memory - otherwise exit 137)
* ~ 5min build time (first build)
* Result: ~ 140mb

> Build [`docker build -t app-native .`]

> run [`docker run --rm -p 8080:8080 app-native`]

> Build & Run [`docker build -t app-native . && docker run --rm -p 8080:8080 app-native`]


[build_shield]: https://github.com/codespacedev/spring-boot-native-example/workflows/JAVA_RELEASE/badge.svg

[build_link]: https://github.com/codespacedev/spring-boot-native-example/actions?query=workflow%3AMVN_RELEASE

[maintainable_shield]: https://img.shields.io/codeclimate/maintainability/codespacedev/spring-boot-native-example?style=flat-square

[maintainable_link]: https://codeclimate.com/github/codespacedev/spring-boot-native-example/maintainability

[coverage_shield]: https://img.shields.io/codeclimate/coverage/codespacedev/spring-boot-native-example?style=flat-square

[coverage_link]: https://codeclimate.com/github/codespacedev/spring-boot-native-example/test_coverage

[issues_shield]: https://img.shields.io/github/issues/codespacedev/spring-boot-native-example?style=flat-square

[issues_link]: https://github.com/codespacedev/spring-boot-native-example/commits/main

[commit_shield]: https://img.shields.io/github/last-commit/codespacedev/spring-boot-native-example?style=flat-square

[commit_link]: https://github.com/codespacedev/spring-boot-native-example/issues

[license_shield]: https://img.shields.io/github/license/codespacedev/spring-boot-native-example?style=flat-square

[license_link]: https://github.com/codespacedev/spring-boot-native-example/blob/main/LICENSE

[dependency_shield]: https://img.shields.io/librariesio/github/codespacedev/spring-boot-native-example?style=flat-square

[dependency_link]: https://libraries.io/github/codespacedev/spring-boot-native-example

[central_shield]: https://img.shields.io/maven-central/v/berlin.yuna/spring-boot-native-example?style=flat-square

[central_link]:https://search.maven.org/artifact/berlin.yuna/spring-boot-native-example

[tag_shield]: https://img.shields.io/github/v/tag/codespacedev/spring-boot-native-example?style=flat-square

[tag_link]: https://github.com/codespacedev/spring-boot-native-example/releases

[javadoc_shield]: https://javadoc.io/badge2/berlin.yuna/spring-boot-native-example/javadoc.svg?style=flat-square

[javadoc_link]: https://javadoc.io/doc/berlin.yuna/spring-boot-native-example

[size_shield]: https://img.shields.io/github/repo-size/codespacedev/spring-boot-native-example?style=flat-square

[label_shield]: https://img.shields.io/badge/Dev-CodeSpace-blueviolet?style=flat-square

[gitter_shield]: https://img.shields.io/gitter/room/codespacedev/spring-boot-native-example?style=flat-square

[gitter_link]: https://gitter.im/spring-boot-native-example/Lobby

[java_version]: https://img.shields.io/badge/java-17-blueviolet?style=flat-square

[spring_boot]: https://img.shields.io/badge/springboot-3-blueviolet?style=flat-square
