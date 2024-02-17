package dev.pradeep.ReminderAppBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"dev.pradeep.*"})
@EnableJpaRepositories(basePackages = "dev.pradeep.*")
@EntityScan(basePackages = "dev.pradeep.*")
public class ReminderAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReminderAppBackendApplication.class, args);
    }

}
