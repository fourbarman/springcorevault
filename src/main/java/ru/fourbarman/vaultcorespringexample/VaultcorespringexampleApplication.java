package ru.fourbarman.vaultcorespringexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ru.fourbarman.vaultcorespringexample.configuration.VaultConfiguration;

//import ru.fourbarman.vaultcorespringexample.configuration.VaultConfiguration;
//@PropertySources({
//        @PropertySource("classpath:application-${spring.profiles.active}.yml")
//})
@ComponentScan
@EnableAutoConfiguration
@Configuration
public class VaultcorespringexampleApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(VaultcorespringexampleApplication.class);

    @Autowired
    public Environment environment;

    @Autowired
    private VaultConfiguration vaultConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(VaultcorespringexampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("----------------------------------------");
        logger.info("Configuration properties");
        logger.info("   username is {}", environment.getProperty("db.username"));
        logger.info("   password is {}", environment.getProperty("db.password"));
        logger.info("----------------------------------------");
        logger.info("Vault configuration");
        logger.info("-----------------------------------------");
        logger.info("   username from bean {}", vaultConfiguration.getUsername());
        logger.info("   password from bean {}", vaultConfiguration.getPassword());
        logger.info("-----------------------------------------");
        logger.info("-----------------------------------------");
        logger.info("   username from application.yml {}", environment.getProperty("spring.datasource.username"));
        logger.info("   password from application.yml {}", environment.getProperty("spring.datasource.password"));
        logger.info("-----------------------------------------");
    }

}
