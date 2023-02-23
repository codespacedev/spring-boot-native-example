package dev.codespace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.lineSeparator;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;
import static java.util.stream.StreamSupport.stream;

@RestController
@RequestMapping("/envs")
public class EnvController {

    @Autowired
    private ApplicationContext context;

    @GetMapping
    public String home() {
        return envAsString(resolveProperties(context.getEnvironment()));
    }

    public static String envAsString(final Map<String, String> input) {
        final Map<String, String> result = new HashMap<>(System.getenv());
        System.getProperties().forEach((key, value) -> result.put(String.valueOf(key), String.valueOf(value)));
        ofNullable(input).ifPresent(result::putAll);
        return result
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(e -> !e.getKey().toLowerCase().endsWith("_pass"))
                .filter(e -> !e.getKey().toLowerCase().endsWith("_password"))
                .filter(e -> !e.getKey().toLowerCase().endsWith("_secret"))
                .filter(e -> !e.getKey().toLowerCase().endsWith("_key"))
                .filter(e -> !e.getKey().toLowerCase().endsWith("_token"))
                .map(e -> "  \"" + e.getKey() + "\": \"" + e.getValue() + "\"")
                .collect(joining(lineSeparator(), "{" + lineSeparator(), lineSeparator() + "}"));
    }

    private static Map<String, String> resolveProperties(final Environment env) {
        final Map<String, String> result = new HashMap<>();
        final MutablePropertySources sources = ((AbstractEnvironment) env).getPropertySources();
        stream(sources.spliterator(), false)
                .filter(EnumerablePropertySource.class::isInstance)
                .map(ps -> ((EnumerablePropertySource<?>) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .distinct()
                .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
                .forEach(prop -> result.put(prop, env.getProperty(prop)));
        return result;
    }
}
