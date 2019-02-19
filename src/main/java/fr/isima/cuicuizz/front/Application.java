package fr.isima.cuicuizz.front;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(QuestionClient quoteClient) {
		return args -> {

			final GetQuestionResponse response = quoteClient.getQuestion(3);
			System.err.println(response.getQuestion().getValue());
		};
	}

}
