# SpringBootRestExampleApp

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


Example of how to run *Spring Boot Native* **without parent**

### Features

* Build executable jar
* Build native image with graalvm

### Requirements

* [Graalvm](https://www.graalvm.org/22.0/docs/getting-started/#install-graalvm) ([brew](https://github.com/graalvm/homebrew-tap))
* Create native image (`gu install native-image`)

## Rest

* Print all envs (without secrets)

> GET http://localhost:8080/envs

## Jar

> Build [`./mvn clean package`]

> Run [`java -jar target/app.jar`]

> Build & Run [`./mvn clean package && java -jar target/app.jar`]

## Native

> Build [`./mvn clean package -Pnative`]

> Run [`java -jar target/app.native`]

> Build & Run [`./mvn clean package && target/app.native`]

## Docker with Native

> **Note**
> Only works **on linux** as the docker **image is debian** and the native image compiles only for the current system

> Build [`./mvn clean package -Pnative`]

> Build docker image [`docker build -t app-native .`]

> run [`docker run --rm -p 8080:8080 app-native`]

> Build & Run [`./mvn clean package && docker build -t app-native . && docker run --rm -p 8080:8080 app-native`]


[build_shield]: https://github.com/YunaBraska/Spring-Boot-Native-Example/workflows/MVN_TEST/badge.svg

[build_link]: https://github.com/YunaBraska/Spring-Boot-Native-Example/actions?query=workflow%3AMVN_RELEASE

[maintainable_shield]: https://img.shields.io/codeclimate/maintainability/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[maintainable_link]: https://codeclimate.com/github/YunaBraska/Spring-Boot-Native-Example/maintainability

[coverage_shield]: https://img.shields.io/codeclimate/coverage/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[coverage_link]: https://codeclimate.com/github/YunaBraska/Spring-Boot-Native-Example/test_coverage

[issues_shield]: https://img.shields.io/github/issues/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[issues_link]: https://github.com/YunaBraska/Spring-Boot-Native-Example/commits/main

[commit_shield]: https://img.shields.io/github/last-commit/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[commit_link]: https://github.com/YunaBraska/Spring-Boot-Native-Example/issues

[license_shield]: https://img.shields.io/github/license/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[license_link]: https://github.com/YunaBraska/Spring-Boot-Native-Example/blob/main/LICENSE

[dependency_shield]: https://img.shields.io/librariesio/github/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[dependency_link]: https://libraries.io/github/YunaBraska/Spring-Boot-Native-Example

[central_shield]: https://img.shields.io/maven-central/v/berlin.yuna/Spring-Boot-Native-Example?style=flat-square

[central_link]:https://search.maven.org/artifact/berlin.yuna/Spring-Boot-Native-Example

[tag_shield]: https://img.shields.io/github/v/tag/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[tag_link]: https://github.com/YunaBraska/Spring-Boot-Native-Example/releases

[javadoc_shield]: https://javadoc.io/badge2/berlin.yuna/Spring-Boot-Native-Example/javadoc.svg?style=flat-square

[javadoc_link]: https://javadoc.io/doc/berlin.yuna/Spring-Boot-Native-Example

[size_shield]: https://img.shields.io/github/repo-size/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[label_shield]: https://img.shields.io/badge/Dev-CodeSpace-blueviolet?style=flat-square

[gitter_shield]: https://img.shields.io/gitter/room/YunaBraska/Spring-Boot-Native-Example?style=flat-square

[gitter_link]: https://gitter.im/Spring-Boot-Native-Example/Lobby

[java_version]: https://img.shields.io/badge/java-17-blueviolet?style=flat-square

[spring_boot]: https://img.shields.io/badge/springboot-3-blueviolet?style=flat-square
