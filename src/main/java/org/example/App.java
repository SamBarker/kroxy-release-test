package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.kroxylicious.proxy.KafkaProxy;
import io.kroxylicious.proxy.config.ConfigParser;
import io.kroxylicious.proxy.config.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Starting Proxy");
        try (final KafkaProxy kafkaProxy = startProxy("etc/example-proxy-config.yml")) {
            kafkaProxy.block();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static KafkaProxy startProxy(String config) throws InterruptedException {
        final Path path = Path.of(config).toAbsolutePath();
        try {
            Configuration proxyConfig = new ConfigParser().parseConfiguration(Files.newInputStream(path));
            KafkaProxy kafkaProxy = new KafkaProxy(proxyConfig);
            kafkaProxy.startup();

            return kafkaProxy;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
