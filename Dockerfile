FROM debian:bullseye-slim
COPY ./target/app.native app.native
EXPOSE 8080
ENTRYPOINT ["./app.native"]
