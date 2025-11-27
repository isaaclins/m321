package ch.clip.bugtracker.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class PersonServiceApplication {

    private Logger log = Logger.getLogger(PersonServiceApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(PersonRepository personRepository) {
        return (args) -> {
            Person person1 = new Person("John", "Doe");
            Person person2 = new Person("Jane", "Smith");
            Person person3 = new Person("Max", "Mustermann");
            Person person4 = new Person("Maria", "Mueller");
            Person person5 = new Person("Peter", "Parker");

            personRepository.save(person1);
            personRepository.save(person2);
            personRepository.save(person3);
            personRepository.save(person4);
            personRepository.save(person5);

            log.info("Saved Person: " + person1.getFirstName() + " " + person1.getLastName());
            log.info("Saved Person: " + person2.getFirstName() + " " + person2.getLastName());
            log.info("Saved Person: " + person3.getFirstName() + " " + person3.getLastName());
            log.info("Saved Person: " + person4.getFirstName() + " " + person4.getLastName());
            log.info("Saved Person: " + person5.getFirstName() + " " + person5.getLastName());
        };
    }
}
