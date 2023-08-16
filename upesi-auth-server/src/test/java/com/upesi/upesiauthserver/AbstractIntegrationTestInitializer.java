package com.upesi.upesiauthserver;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;
import java.util.stream.Stream;

import static java.lang.String.format;

@Slf4j
public class AbstractIntegrationTestInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Integer WIRE_MOCK_PORT = 8111;
    private static final String TEST_DATABASE_NAME = "test_database";
    private static final String TEST_DATABASE_USERNAME = "test";
    private static final String TEST_DATABASE_PASSWORD = "test";
    public static final Integer MAX_ATTEMPTS = 5;

    private static final Network network = Network.newNetwork();

    protected static final DockerImageName MARIADB_IMAGE = DockerImageName.parse("mariadb:10.5.5");
    protected static final MariaDBContainer<?> mariaDB = new MariaDBContainer<>(MARIADB_IMAGE)
            .withCommand("--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci")
            .withDatabaseName(TEST_DATABASE_NAME)
            .withUsername(TEST_DATABASE_USERNAME)
            .withPassword(TEST_DATABASE_PASSWORD)
            .withNetwork(network);
    protected static final GenericContainer<?> redis =
                new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine")).withExposedPorts(6379);

    public static final WireMockServer wireMockServer =
            new WireMockServer(new WireMockConfiguration().port(WIRE_MOCK_PORT));

    protected void startContainers() {
        Startables.deepStart(Stream.of(mariaDB)).join();
        redis.start();
    }

    private void startWireMock() {
        wireMockServer.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        startContainers();
        startWireMock();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        applicationContext.getBeanFactory().registerSingleton("wireMockServer", wireMockServer);

        applicationContext.addApplicationListener(applicationEvent -> {
            if (applicationEvent instanceof ContextClosedEvent) {
                wireMockServer.stop();
            }
        });

        environment.getPropertySources()
                .addFirst(new MapPropertySource("application", Map.of(
                        "spring.r2dbc.url", mariaDB.getJdbcUrl().replaceFirst("jdbc", "r2dbc"),
                        "spring.r2dbc.username", mariaDB.getUsername(),
                        "spring.r2dbc.password", mariaDB.getPassword()
                )));
    }

    @DynamicPropertySource
    private static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        // R2DBC DataSource Example
        registry.add("spring.r2dbc.url", () ->
                format("r2dbc:tc:mariadb://%s:%d/%s",
                        mariaDB.getHost(),
                        mariaDB.getFirstMappedPort(),
                        mariaDB.getDatabaseName()));
        registry.add("spring.r2dbc.username", mariaDB::getUsername);
        registry.add("spring.r2dbc.password", mariaDB::getPassword);
    }
}

