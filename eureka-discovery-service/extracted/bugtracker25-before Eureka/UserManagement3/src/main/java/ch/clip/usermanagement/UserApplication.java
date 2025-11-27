package ch.clip.usermanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class UserApplication {
	private Logger log = Logger.getLogger(String.valueOf(UserApplication.class));

	public static void main(String... args) {
		SpringApplication.run(UserApplication.class, args);

	}



	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		// https://spring.io/guides/gs/accessing-data-jpa/
		return (args) -> {
			//create People
			Person person1 = new Person("Mary", "Richards", "SW-Engineer");
			Person person2 = new Person("Toya", "Stewart", "UX-Engineer");
			Person person3 = new Person("Jeff", "Stone", "SW-Engineer");
			Person person4 = new Person("Dean", "Toms", "SW-Engineer");

			personRepository.save(person1);
			personRepository.save(person2);
			personRepository.save(person3);
			personRepository.save(person4);

		};
	}


}
