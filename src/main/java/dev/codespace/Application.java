package dev.codespace;

import dev.codespace.controller.EnvController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(final String... args) {
        LOG.info(EnvController.envAsString(null));
        SpringApplication.run(Application.class, args);
    }
}
