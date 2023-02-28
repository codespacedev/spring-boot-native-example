#AMD64 && ARM64
FROM debian:bullseye-slim as graalvm_setup
ENV GRAALVM_HOME "/usr/local/graalvm"
ENV GRAALVM_VERSION "vm-22.3.1"
ENV JAVA_VERSION "17"

RUN set -eux \
	&& mkdir -p "${GRAALVM_HOME}" \
    && apt-get update -qqy  \
    && apt-get install -qqy curl \
    && apt-get install -qqy --no-install-recommends build-essential libz-dev zlib1g-dev \
    && curl -sSL -o graalvm.tar.gz "https://github.com/graalvm/graalvm-ce-builds/releases/download/${GRAALVM_VERSION}/graalvm-ce-java${JAVA_VERSION}-linux-$(if echo "$(uname -m)" | grep -q -E '(arm|aarch)'; then echo "aarch64"; else echo "amd64"; fi;)-22.3.1.tar.gz" \
    && tar -zxf graalvm.tar.gz -C "${GRAALVM_HOME}" --strip-components 1 \
    && rm -f graalvm.tar.gz \
	&& apt-get clean \
	&& rm -rf /var/lib/apt/lists/* \
	&& ${GRAALVM_HOME}/bin/gu install native-image

FROM graalvm_setup as copy_sources
COPY src ./src
COPY .mvn ./.mvn
COPY mvnw pom.xml ./

FROM copy_sources as native_build
RUN (chmod +x mvnw && JAVA_HOME="${GRAALVM_HOME}" ./mvnw clean package -B -q -DskipTests -Pnative)

FROM debian:bullseye-slim as native_image
COPY --from=native_build ./target/app.native ./
EXPOSE 8080
ENTRYPOINT ["./app.native"]
