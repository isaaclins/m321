package ch.clip.bugtracker.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class ApplicationServiceApplication {

    private Logger log = Logger.getLogger(ApplicationServiceApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(ApplicationRepository applicationRepository) {
        return (args) -> {
            Application app1 = new Application("Bug Tracker", 1, "A system for tracking bugs and issues");
            Application app2 = new Application("Task Manager", 2, "A project task management application");
            Application app3 = new Application("Code Review Tool", 3, "Tool for reviewing code changes");
            Application app4 = new Application("CI/CD Pipeline", 1, "Continuous integration and deployment system");
            Application app5 = new Application("Documentation Portal", 4, "Central documentation management");

            applicationRepository.save(app1);
            applicationRepository.save(app2);
            applicationRepository.save(app3);
            applicationRepository.save(app4);
            applicationRepository.save(app5);

            log.info("Saved Application: " + app1.getName());
            log.info("Saved Application: " + app2.getName());
            log.info("Saved Application: " + app3.getName());
            log.info("Saved Application: " + app4.getName());
            log.info("Saved Application: " + app5.getName());
        };
    }
}
