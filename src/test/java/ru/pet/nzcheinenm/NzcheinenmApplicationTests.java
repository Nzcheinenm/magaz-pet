package ru.pet.nzcheinenm;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.pet.nzcheinenm.repository.ReactiveProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {NzcheinenmApplicationTests.Initializer.class})
@ActiveProfiles("test")
class NzcheinenmApplicationTests {

    private static int POSTGRES_PORT = 5432;

    @Autowired
    private ReactiveProductRepository fooRepository;

    @ClassRule
    public static PostgreSQLContainer postgres = new PostgreSQLContainer<>("postgres")
            .withDatabaseName("foo")
            .withUsername("it_user")
            .withPassword("it_pass")
            .withInitScript("sql/init_postgres.sql");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.data.postgres.host=" + postgres.getContainerIpAddress(),
                    "spring.data.postgres.port=" + postgres.getMappedPort(POSTGRES_PORT),
                    "spring.data.postgres.username=" + postgres.getUsername(),
                    "spring.data.postgres.password=" + postgres.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    public void testApp() {
    }

}




