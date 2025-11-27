package ch.bbw.bugtracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class ApplicationCatalogApplication {

	private Logger log = Logger.getLogger(String.valueOf(ApplicationCatalogApplication.class));


	public static void main(String... args) {
		SpringApplication.run(ApplicationCatalogApplication.class, args);

	}



	@Bean
	public CommandLineRunner demoData(ApplicationRepository applicationRepository) {
		// https://spring.io/guides/gs/accessing-data-jpa/
		return (args) -> {

			Application app1 = new Application( "Bug Tracker", 1,"An app to track defects.", "john Doe", "Business - Owner");
			Application app2 = new Application("Project Tracker", 2,"An app to track project management tasks.", "Carla May", "Business - Owner");
			applicationRepository.save(app1);
			applicationRepository.save(app2);

			log.info("Saved App - id: " + app1.getId());
			log.info("Saved App - id: " + app2.getId());



		};
	}
}
